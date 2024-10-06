package com.pdp.PixelTrade.scheduler;

import com.pdp.PixelTrade.service.otp.OtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Aliabbos Ashurov
 * @since 06/October/2024  13:01
 **/
@Component
@RequiredArgsConstructor
public class OtpScheduler {

    private final OtpService otpService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void softDeleteExpiredOtps() {
        otpService.softDeleteExpiredOtps();
    }

    @Scheduled(cron = "0 0 0 * * MON")
    public void deleteExpiredOtps() {
        otpService.deleteExpiredOtps();
    }
}
