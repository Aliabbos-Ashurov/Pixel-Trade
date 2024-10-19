package com.pdp.PixelTrade.service.wallet;

import com.pdp.PixelTrade.dto.ApiResponse;
import com.pdp.PixelTrade.entity.wallet.MiningEvent;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.repository.wallet.MiningEventRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 14/October/2024  11:27
 **/
@Service
@RequiredArgsConstructor
public class MiningEventService {

    private final MiningEventRepository miningEventRepository;

    public ApiResponse<List<MiningEvent>> findByCryptoType(@NotNull CryptoType cryptoType) {
        return ApiResponse.ok(miningEventRepository.findByCryptoType(cryptoType));
    }

    public ApiResponse<List<MiningEvent>> findByTimeRange(@NotNull LocalDateTime start,
                                                          @NotNull LocalDateTime end) {
        return ApiResponse.ok(miningEventRepository.findByTimeRange(start, end));
    }

    public ApiResponse<List<MiningEvent>> findCurrentlyActiveEvents(@NotNull LocalDateTime currentTime) {
        return ApiResponse.ok(miningEventRepository.findCurrentlyActiveEvents(currentTime));
    }

    public ApiResponse<List<MiningEvent>> findExpiredEvents(@NotNull LocalDateTime currentTime) {
        return ApiResponse.ok(miningEventRepository.findExpiredEvents(currentTime));
    }

    public long countByCryptoType(@NotNull CryptoType cryptoType) {
        return miningEventRepository.countByCryptoType(cryptoType);
    }

    public BigDecimal getTotalAmountByCryptoType(@NotNull CryptoType cryptoType) {
        return miningEventRepository.getTotalAmountByCryptoType(cryptoType);
    }
}
