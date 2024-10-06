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

import java.util.List;
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

    public Otp findActiveOtp(@NotNull String recipient, @NotNull String code) {
        validateCode(code);
        return getOtp(otpRepository.findActive(code, recipient));
    }

    public Otp findOtpById(@NotNull Long id) {
        return getOtp(otpRepository.findById(id));
    }

    public Otp findOtpByCode(@NotNull String code) {
        validateCode(code);
        return getOtp(otpRepository.findByCode(code));
    }

    public boolean hasActiveOtp(@NotNull String recipient) {
        return otpRepository.hasActiveOtp(recipient);
    }

    public Otp findOtpByCodeAndNotUsed(@NotNull String code) {
        validateCode(code);
        return getOtp(otpRepository.findByCodeAndNotUsed(code));
    }

    public List<Otp> findExpiredOtps() {
        return otpRepository.findExpiredOtps();
    }

    public List<Otp> findAllActiveOtps() {
        return otpRepository.findAllActiveOtps();
    }

    public long countUnusedOtpsByType(@NotNull OtpType type) {
        return otpRepository.countUnusedOtpsByType(type);
    }

    @Transactional
    public void markOtpAsUsed(@NotNull String code) {
        validateCode(code);
        otpRepository.markOtpAsUsed(code);
    }

    @Transactional
    public void markOtpAsUsedAndSoftDelete(@NotNull String code) {
        validateCode(code);
        otpRepository.markOtpAsUsedAndSoftDelete(code);
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
