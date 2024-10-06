package com.pdp.PixelTrade.service.otp;

import com.pdp.PixelTrade.dto.request.OtpSendRequestDTO;
import com.pdp.PixelTrade.dto.request.OtpVerifyRequestDTO;
import com.pdp.PixelTrade.dto.response.OtpResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Aliabbos Ashurov
 * @since 05/October/2024  19:19
 **/
@Service
@RequiredArgsConstructor
public class SmsOtpService implements OtpVerificationService {

    @Override
    public void send(OtpSendRequestDTO request) {
    }

    @Override
    public OtpResponseDTO verify(OtpVerifyRequestDTO request) {
        return null;
    }
}
