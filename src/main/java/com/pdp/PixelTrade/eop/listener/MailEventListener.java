package com.pdp.PixelTrade.eop.listener;

import com.pdp.PixelTrade.eop.event.MailPasswordEvent;
import com.pdp.PixelTrade.eop.event.SendBackupMailEvent;
import com.pdp.PixelTrade.eop.event.VerifyBackupMailEvent;
import com.pdp.PixelTrade.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author Aliabbos Ashurov
 * @since 23/October/2024  11:08
 **/
@Component
@RequiredArgsConstructor
public class MailEventListener {

    private final MailService mailService;

    @Async
    @EventListener(classes = MailPasswordEvent.class, condition = "#event.recipient() ne null")
    public void sendPasswordChanging(MailPasswordEvent event) {
        mailService.sendPasswordChanging(event.recipient());
    }

    @Async
    @EventListener(classes = SendBackupMailEvent.class,
            condition = "#event.mail() ne null")
    public void sendBackupMail(SendBackupMailEvent event) {
        mailService.sendBackupMail(event.userId(), event.mail());
    }

    @Async
    @EventListener(classes = VerifyBackupMailEvent.class,
            condition = "#event.userId() ne null")
    public void verifyBackupMail(VerifyBackupMailEvent event) {
        mailService.verifyBackupMail(event.userId(), event.mail());
    }
}
