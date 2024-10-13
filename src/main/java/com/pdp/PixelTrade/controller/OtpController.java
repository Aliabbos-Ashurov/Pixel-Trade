package com.pdp.PixelTrade.controller;

import com.pdp.PixelTrade.dto.request.OtpSendRequestDTO;
import com.pdp.PixelTrade.dto.request.OtpVerifyRequestDTO;
import com.pdp.PixelTrade.dto.response.OtpResponseDTO;
import com.pdp.PixelTrade.event.EmailOtpSentEvent;
import com.pdp.PixelTrade.event.PhoneOtpSentEvent;
import com.pdp.PixelTrade.service.otp.OtpVerificationService;
import com.pdp.PixelTrade.utils.Constants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
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


    @PostMapping("/send-email")
    public ResponseEntity<Void> sendEmail(@Valid @RequestBody OtpSendRequestDTO dto) {
        publisher.publishEvent(new EmailOtpSentEvent(dto.recipient()));
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/send-phone")
    public ResponseEntity<OtpResponseDTO> sendPhone(@Valid @RequestBody OtpSendRequestDTO dto) {
        publisher.publishEvent(new PhoneOtpSentEvent(dto.recipient()));
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/send-backup-mail")
    public ResponseEntity<OtpResponseDTO> sendBackupMail(@Valid @RequestBody OtpSendRequestDTO dto) {
        return null;
    }

    @PostMapping("/verify-email")
    public ResponseEntity<OtpResponseDTO> verifyEmail(@Valid @RequestBody OtpVerifyRequestDTO dto) {
        return ResponseEntity.ok(mailOtpService.verify(dto));
    }

    @PostMapping("/verify-phone")
    public ResponseEntity<OtpResponseDTO> verifyPhone(@Valid @RequestBody OtpVerifyRequestDTO dto) {
        return ResponseEntity.ok(smsOtpService.verify(dto));
    }

    @GetMapping("/verify-backup-mail/{code}")
    public ResponseEntity<OtpResponseDTO> verifyBackupMail(@PathVariable String code) {
        return null;
    }
}
