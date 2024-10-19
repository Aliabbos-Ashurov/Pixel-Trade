package com.pdp.PixelTrade.service.wallet;

import com.pdp.PixelTrade.dto.ApiResponse;
import com.pdp.PixelTrade.entity.wallet.WalletSuspicionRecord;
import com.pdp.PixelTrade.repository.wallet.WalletSuspicionRecordRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 14/October/2024  10:07
 **/
@Service
@RequiredArgsConstructor
public class WalletSuspicionRecordService {
    private final WalletSuspicionRecordRepository walletSuspicionRecordRepository;

    public boolean exists(@NotNull String address) {
        return walletSuspicionRecordRepository.exists(address);
    }

    public ApiResponse<List<WalletSuspicionRecord>> findByWalletAddress(@NotNull String address) {
        return ApiResponse.ok(walletSuspicionRecordRepository.findByWalletAddress(address));
    }

    public ApiResponse<List<WalletSuspicionRecord>> findByReasonContaining(@NotNull String reason) {
        return ApiResponse.ok(walletSuspicionRecordRepository.findByReasonContaining(reason));
    }

    public ApiResponse<List<WalletSuspicionRecord>> findByCreatedAtRange(
            @NotNull LocalDateTime startDate,
            @NotNull LocalDateTime endDate) {
        return ApiResponse.ok(walletSuspicionRecordRepository.findByCreatedAtRange(startDate, endDate));
    }

    public long countSuspectRecordsByWallet(@NotNull String address) {
        return walletSuspicionRecordRepository.countSuspectRecordsByWallet(address);
    }
}
