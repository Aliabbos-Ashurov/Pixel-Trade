package com.pdp.PixelTrade.service.otp;

import com.pdp.PixelTrade.entity.Otp;
import com.pdp.PixelTrade.enums.OtpType;
import com.pdp.PixelTrade.exceptions.otp.InvalidOtpCodeException;
import com.pdp.PixelTrade.exceptions.otp.OtpNotFoundException;
import com.pdp.PixelTrade.repository.OtpRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Aliabbos Ashurov
 * @since 06/October/2024  11:26
 **/
@Service
@RequiredArgsConstructor
public class OtpService {

    private final OtpRepository otpRepository;

    public void save(@NotNull String recipient, @NotNull String code, @NotNull OtpType otpType) {
        otpRepository.save(Otp.builder()
                .code(code)
                .type(otpType)
                .recipient(recipient)
                .build());
    }

    public boolean isOtpUsedByRecipient(@NotNull String recipient, @NotNull OtpType type) {
        return otpRepository.isOtpUsedByRecipient(recipient, type);
    }

    public Otp findActiveOtp(@NotNull String recipient, @NotNull String code) {
        validateCode(code);
        return getOtp(otpRepository.findActive(code, recipient));
    }

    public boolean hasActiveOtp(@NotNull String recipient) {
        return otpRepository.hasActiveOtp(recipient);
    }

    @Transactional
    public void markOtpAsUsed(@NotNull String recipient, @NotNull String code) {
        validateCode(code);
        otpRepository.markOtpAsUsed(recipient, code);
    }

    @Transactional
    public void softDeleteExpiredOtps() {
        otpRepository.softDeleteExpiredOtps();
    }

    @Transactional
    public void deleteExpiredOtps() {
        otpRepository.deleteExpiredOtps();
    }

    private Otp getOtp(Optional<Otp> otp) {
        return otp.orElseThrow(() -> new OtpNotFoundException("Otp not found"));
    }

    private void validateCode(@NotNull String code) {
        if (!code.matches("\\d{6}")) {
            throw new InvalidOtpCodeException("Invalid otp code: " + code);
        }
    }
}
