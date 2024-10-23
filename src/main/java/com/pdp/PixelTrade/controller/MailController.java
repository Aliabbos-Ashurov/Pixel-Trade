package com.pdp.PixelTrade.controller;

import com.pdp.PixelTrade.dto.mail.SendBackupMailDTO;
import com.pdp.PixelTrade.eop.event.SendBackupMailEvent;
import com.pdp.PixelTrade.eop.event.VerifyBackupMailEvent;
import com.pdp.PixelTrade.utils.Constants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Aliabbos Ashurov
 * @since 23/October/2024  12:20
 **/
@RestController
@RequestMapping(Constants.BASE_PATH_V1 + "/mail")
@RequiredArgsConstructor
public class MailController {

    private final ApplicationEventPublisher publisher;

    @PostMapping(value = "/send-backup-mail", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> sendBackupMail(@Valid @RequestBody SendBackupMailDTO dto) {
        publisher.publishEvent(new SendBackupMailEvent(dto.userId(), dto.mail()));
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/verify-backup-mail/{id}/{mail}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> verifyBackupMail(@PathVariable Long id, @PathVariable String mail) {
        publisher.publishEvent(new VerifyBackupMailEvent(id, mail));
        return ResponseEntity.noContent().build();
    }
}
