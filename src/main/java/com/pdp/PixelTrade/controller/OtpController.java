package com.pdp.PixelTrade.controller;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.auth.OtpResponseDTO;
import com.pdp.PixelTrade.dto.auth.OtpSendRequestDTO;
import com.pdp.PixelTrade.dto.auth.OtpVerifyRequestDTO;
import com.pdp.PixelTrade.event.EmailOtpSentEvent;
import com.pdp.PixelTrade.event.PhoneOtpSentEvent;
import com.pdp.PixelTrade.service.otp.OtpVerificationService;
import com.pdp.PixelTrade.utils.Constants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Aliabbos Ashurov
 * @since 06/October/2024  10:57
 **/
@RestController
@RequestMapping(Constants.BASE_PATH_V1 + "/otp")
@RequiredArgsConstructor
public class OtpController {

    private final ApplicationEventPublisher publisher;
    private final OtpVerificationService mailOtpService;
    private final OtpVerificationService smsOtpService;


    @PostMapping(value = "/send-email", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> sendEmail(@Valid @RequestBody OtpSendRequestDTO dto) {
        publisher.publishEvent(new EmailOtpSentEvent(dto.recipient()));
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/send-phone", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> sendPhone(@Valid @RequestBody OtpSendRequestDTO dto) {
        publisher.publishEvent(new PhoneOtpSentEvent(dto.recipient()));
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/send-backup-mail", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> sendBackupMail(@Valid @RequestBody OtpSendRequestDTO dto) {
        return null;
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

    @GetMapping(value = "/verify-backup-mail/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<OtpResponseDTO>> verifyBackupMail(@PathVariable String code) {
        return null;
    }
}
