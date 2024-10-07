package com.pdp.PixelTrade.event;

import com.pdp.PixelTrade.dto.request.OtpSendRequestDTO;
import com.pdp.PixelTrade.service.otp.OtpVerificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author Aliabbos Ashurov
 * @since 06/October/2024  14:45
 **/
@Component
@RequiredArgsConstructor
public class OtpEventListener {

    private final OtpVerificationService mailOtpService;

    @Async
    @EventListener(classes = OtpSentEvent.class, condition = "#event.recipient() ne null")
    public void onOtpSentEvent(OtpSentEvent event) {
        mailOtpService.send(new OtpSendRequestDTO(event.recipient()));
    }
}
