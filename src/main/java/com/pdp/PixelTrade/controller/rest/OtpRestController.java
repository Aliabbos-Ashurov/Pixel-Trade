package com.pdp.PixelTrade.controller.rest;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.auth.OtpResponseDTO;
import com.pdp.PixelTrade.dto.auth.OtpSendRequestDTO;
import com.pdp.PixelTrade.dto.auth.OtpVerifyRequestDTO;
import com.pdp.PixelTrade.eop.event.EmailOtpSentEvent;
import com.pdp.PixelTrade.eop.event.PhoneOtpSentEvent;
import com.pdp.PixelTrade.exceptions.otp.EmailConflictException;
import com.pdp.PixelTrade.service.UserService;
import com.pdp.PixelTrade.service.otp.OtpVerificationService;
import com.pdp.PixelTrade.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.pdp.PixelTrade.utils.HttpMethod._POST;

/**
 * @author Aliabbos Ashurov
 * @since 06/October/2024  10:57
 **/
@RestController
@RequestMapping(Constants.BASE_PATH_V1 + "/otp")
@RequiredArgsConstructor
public class OtpRestController {

    private final ApplicationEventPublisher publisher;
    private final OtpVerificationService mailOtpService;
    private final OtpVerificationService smsOtpService;
    private final UserService userService;

    @Operation(method = _POST,
            summary = "sending email to otp",
            responses = {@ApiResponse(responseCode = "429",
                    description = "after trying more than one",
                    content = @Content(mediaType = "application/json"))})
    @PostMapping(value = "/send-email", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> sendEmail(@Valid @RequestBody OtpSendRequestDTO dto) {
        userService.isNotExistMail(dto.recipient(),
                () -> new EmailConflictException("Email already exist: {0}", dto.recipient()));
        publisher.publishEvent(new EmailOtpSentEvent(dto.recipient()));
        return ResponseEntity.noContent().build();
    }

    @Operation(method = _POST,
            summary = "sending otp to phone number (TEST)",
            responses = @ApiResponse(
                    responseCode = "429",
                    description = "after trying more than one",
                    content = @Content(mediaType = "application/json")
            ))
    @PostMapping(value = "/send-phone", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> sendPhone(@Valid @RequestBody OtpSendRequestDTO dto) {
        publisher.publishEvent(new PhoneOtpSentEvent(dto.recipient()));
        return ResponseEntity.noContent().build();
    }


    @Operation(method = _POST,
            summary = "verifying email by sending code",
            responses = @ApiResponse(
                    responseCode = "400",
                    description = "bad request :: otp expired",
                    content = @Content(mediaType = "application/json")))
    @PostMapping(value = "/verify-email")
    public ResponseEntity<Response<OtpResponseDTO>> verifyEmail(@Valid @RequestBody OtpVerifyRequestDTO dto) {
        return ResponseEntity.ok(mailOtpService.verify(dto));
    }

    @Operation(method = _POST,
            summary = "verifying phone by sending code",
            parameters = @Parameter(name = "dto"),
            responses = {
                    @ApiResponse(responseCode = "400",
                            description = "bad request :: otp expired",
                            content = @Content(mediaType = "application/json"))
            })
    @PostMapping(value = "/verify-phone",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<OtpResponseDTO>> verifyPhone(@Valid @RequestBody OtpVerifyRequestDTO dto) {
        return ResponseEntity.ok(smsOtpService.verify(dto));
    }
}
