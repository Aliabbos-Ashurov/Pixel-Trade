package com.pdp.PixelTrade.service.otp;

import com.pdp.PixelTrade.dto.client.MessageRequestDTO;
import com.pdp.PixelTrade.dto.request.OtpSendRequestDTO;
import com.pdp.PixelTrade.dto.request.OtpVerifyRequestDTO;
import com.pdp.PixelTrade.dto.response.OtpResponseDTO;
import com.pdp.PixelTrade.entity.Otp;
import com.pdp.PixelTrade.enums.OtpType;
import com.pdp.PixelTrade.exceptions.otp.OtpExpiredException;
import com.pdp.PixelTrade.exceptions.otp.TooManyOtpRequestsException;
import com.pdp.PixelTrade.exceptions.validation.InvalidInputFormatException;
import com.pdp.PixelTrade.service.client.EskizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author Aliabbos Ashurov
 * @since 05/October/2024  19:19
 **/
@Service
@RequiredArgsConstructor
public class SmsOtpService implements OtpVerificationService {

    private final EskizService eskizService;
    private final OtpService otpService;
    private final static String FROM = "4546";
    private static final String PHONE_REGEX = "^998\\d{9}$";

    @Override
    public void send(OtpSendRequestDTO request) {
        if (!request.recipient().matches(PHONE_REGEX))
            throw new InvalidInputFormatException("Invalid phone number: {0} ",request.recipient());
        if (otpService.hasActiveOtp(request.recipient()))
            throw new TooManyOtpRequestsException("Too many active otp requests with recipient: {0}", request.recipient());
        String code = generateOtpCode();
        eskizService.sendMessage(MessageRequestDTO.of(
                request.recipient(),
                "Bu Eskiz dan test",
                FROM
        ));
        otpService.save(request.recipient(), code, OtpType.PHONE);
    }

    @Override
    public OtpResponseDTO verify(OtpVerifyRequestDTO request) {
        Otp activeOtp = otpService.findActiveOtp(request.recipient(), request.code());
        System.out.println(activeOtp);
        if (activeOtp.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new OtpExpiredException("OTP expired with request code: {0}, recipient: {1}", request.code(), request.recipient());
        }
        otpService.markOtpAsUsed(request.recipient(), request.code());
        return new OtpResponseDTO(true, "OTP verified successfully");
    }
}
