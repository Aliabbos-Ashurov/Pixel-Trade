package com.pdp.PixelTrade.controller;

import com.pdp.PixelTrade.dto.request.OtpSendRequestDTO;
import com.pdp.PixelTrade.dto.request.OtpVerifyRequestDTO;
import com.pdp.PixelTrade.dto.response.OtpResponseDTO;
import com.pdp.PixelTrade.event.OtpSentEvent;
import com.pdp.PixelTrade.service.otp.OtpVerificationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Aliabbos Ashurov
 * @since 06/October/2024  10:57
 **/
@RestController
@RequestMapping("/api/v1/otp")
public class OtpController {

    private final ApplicationEventPublisher publisher;
    private final OtpVerificationService mailOtpService;

    public OtpController(ApplicationEventPublisher publisher, @Qualifier("mailOtpService") OtpVerificationService mailOtpService) {
        this.publisher = publisher;
        this.mailOtpService = mailOtpService;
    }

    @PostMapping("/send-email")
    public ResponseEntity<Void> sendEmail(@Valid @RequestBody OtpSendRequestDTO dto) {
        publisher.publishEvent(new OtpSentEvent(dto.recipient()));
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/send-phone")
    public ResponseEntity<OtpResponseDTO> sendPhone(@Valid @RequestBody OtpSendRequestDTO dto) {
        return null;
    }

    @PostMapping("/send-backup-mail")
    public ResponseEntity<OtpResponseDTO> sendBackupMail(@Valid @RequestBody OtpSendRequestDTO dto) {
        return null;
    }

    @PostMapping("/verify-email")
    public ResponseEntity<OtpResponseDTO> verifyEmail(@Valid @RequestBody OtpVerifyRequestDTO dto) {
        return ResponseEntity.ok(mailOtpService.verify(dto));
    }

    @GetMapping("/verify-phone")
    public ResponseEntity<OtpResponseDTO> verifyPhone(@Valid @RequestBody OtpVerifyRequestDTO dto) {
        return null;
    }

    @GetMapping("/verify-backup-mail/{code}")
    public ResponseEntity<OtpResponseDTO> verifyBackupMail(@PathVariable String code) {
        return null;
    }
}
