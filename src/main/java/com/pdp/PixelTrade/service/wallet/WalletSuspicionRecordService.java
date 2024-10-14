package com.pdp.PixelTrade.service.wallet;

import com.pdp.PixelTrade.dto.ApiResponse;
import com.pdp.PixelTrade.entity.wallet.WalletSuspicionRecord;
import com.pdp.PixelTrade.repository.wallet.WalletSuspicionRecordRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
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

    public ApiResponse<List<WalletSuspicionRecord>> findByWalletAddress(@NotNull @Param("address") String address) {
        return ApiResponse.ok(walletSuspicionRecordRepository.findByWalletAddress(address));
    }

    public ApiResponse<List<WalletSuspicionRecord>> findByReasonContaining(@Param("reason") String reason) {
        return ApiResponse.ok(walletSuspicionRecordRepository.findByReasonContaining(reason));
    }

    public ApiResponse<List<WalletSuspicionRecord>> findByCreatedAtRange(
            @NotNull @Param("startDate") LocalDateTime startDate,
            @NotNull @Param("endDate") LocalDateTime endDate) {
        return ApiResponse.ok(walletSuspicionRecordRepository.findByCreatedAtRange(startDate, endDate));
    }

    public long countSuspectRecordsByWallet(@Param("address") String address) {
        return walletSuspicionRecordRepository.countSuspectRecordsByWallet(address);
    }
}
