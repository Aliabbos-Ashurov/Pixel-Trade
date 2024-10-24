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
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @PostMapping(value = "/send-email", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> sendEmail(@Valid @RequestBody OtpSendRequestDTO dto) {
        userService.isNotExistMail(dto.recipient(),
                () -> new EmailConflictException("Email already exist: {0}", dto.recipient()));
        publisher.publishEvent(new EmailOtpSentEvent(dto.recipient()));
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/send-phone", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> sendPhone(@Valid @RequestBody OtpSendRequestDTO dto) {
        publisher.publishEvent(new PhoneOtpSentEvent(dto.recipient()));
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/verify-email",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<OtpResponseDTO>> verifyEmail(@Valid @RequestBody OtpVerifyRequestDTO dto) {
        return ResponseEntity.ok(mailOtpService.verify(dto));
    }

    @PostMapping(value = "/verify-phone",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<OtpResponseDTO>> verifyPhone(@Valid @RequestBody OtpVerifyRequestDTO dto) {
        return ResponseEntity.ok(smsOtpService.verify(dto));
    }
}
