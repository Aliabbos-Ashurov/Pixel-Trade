package com.pdp.PixelTrade.service.otp;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.auth.OtpResponseDTO;
import com.pdp.PixelTrade.dto.auth.OtpSendRequestDTO;
import com.pdp.PixelTrade.dto.auth.OtpVerifyRequestDTO;
import jakarta.validation.constraints.NotNull;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Aliabbos Ashurov
 * @since 05/October/2024  14:58
 **/
public interface OtpVerificationService {

    void send(@NotNull OtpSendRequestDTO request);


    Response<OtpResponseDTO> verify(@NotNull OtpVerifyRequestDTO request);

    default String generateOtpCode() {
        return String.valueOf(ThreadLocalRandom.current().nextInt(100000, 999999));
    }
}
