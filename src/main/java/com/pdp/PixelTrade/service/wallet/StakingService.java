package com.pdp.PixelTrade.service.wallet;

import com.pdp.PixelTrade.dto.ApiResponse;
import com.pdp.PixelTrade.entity.wallet.Staking;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.repository.wallet.StakingRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 14/October/2024  10:13
 **/
@Service
@RequiredArgsConstructor
public class StakingService {
    private final StakingRepository stakingRepository;

    public ApiResponse<List<Staking>> findByUserId(@NotNull Long userId) {
        return ApiResponse.ok(stakingRepository.findByUserId(userId));
    }

    public ApiResponse<List<Staking>> findByStakingEventId(@NotNull Long eventId) {
        return ApiResponse.ok(stakingRepository.findByStakingEventId(eventId));
    }

    public ApiResponse<List<Staking>> findByCryptoType(@NotNull CryptoType cryptoType) {
        return ApiResponse.ok(stakingRepository.findByCryptoType(cryptoType));
    }

    public ApiResponse<List<Staking>> findByUserIdAndEventId(@NotNull Long userId,
                                                             @NotNull Long eventId) {
        return ApiResponse.ok(stakingRepository.findByUserIdAndEventId(userId, eventId));
    }

    public ApiResponse<List<Staking>> findByDateRange(@NotNull LocalDateTime startDate,
                                                      @NotNull LocalDateTime endDate) {
        return ApiResponse.ok(stakingRepository.findByDateRange(startDate, endDate));
    }

    public ApiResponse<List<Staking>> findByEventIdAndCryptoType(@NotNull Long eventId,
                                                                 @NotNull CryptoType cryptoType) {
        return ApiResponse.ok(stakingRepository.findByEventIdAndCryptoType(eventId, cryptoType));
    }

    public BigDecimal getTotalEarnedByUser(@NotNull Long userId) {
        return stakingRepository.getTotalEarnedByUser(userId);
    }

    public ApiResponse<List<Staking>> findAllOrderByStakeStart() {
        return ApiResponse.ok(stakingRepository.findAllOrderByStakeStart());
    }

    public long countByStakingEventId(@NotNull Long eventId) {
        return stakingRepository.countByStakingEventId(eventId);
    }
}
