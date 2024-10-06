package com.pdp.PixelTrade.service.otp;

import com.pdp.PixelTrade.dto.request.OtpSendRequestDTO;
import com.pdp.PixelTrade.dto.request.OtpVerifyRequestDTO;
import com.pdp.PixelTrade.dto.response.OtpResponseDTO;
import jakarta.validation.constraints.NotNull;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Aliabbos Ashurov
 * @since 05/October/2024  14:58
 **/
public interface OtpVerificationService {

    void send(@NotNull OtpSendRequestDTO request);


    OtpResponseDTO verify(@NotNull OtpVerifyRequestDTO request);

    default String generateOtpCode() {
        return String.valueOf(ThreadLocalRandom.current().nextInt(100000, 999999));
    }
}
