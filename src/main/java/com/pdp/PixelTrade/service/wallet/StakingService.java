package com.pdp.PixelTrade.service.wallet;

import com.pdp.PixelTrade.dto.ApiResponse;
import com.pdp.PixelTrade.entity.wallet.Staking;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.repository.wallet.StakingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
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

    public ApiResponse<List<Staking>> findByUserId(@Param("userId") Long userId) {
        return ApiResponse.ok(stakingRepository.findByUserId(userId));
    }

    public ApiResponse<List<Staking>> findByStakingEventId(@Param("eventId") Long eventId) {
        return ApiResponse.ok(stakingRepository.findByStakingEventId(eventId));
    }

    public ApiResponse<List<Staking>> findByCryptoType(@Param("cryptoType") CryptoType cryptoType) {
        return ApiResponse.ok(stakingRepository.findByCryptoType(cryptoType));
    }

    public ApiResponse<List<Staking>> findByUserIdAndEventId(@Param("userId") Long userId,
                                                             @Param("eventId") Long eventId) {
        return ApiResponse.ok(stakingRepository.findByUserIdAndEventId(userId, eventId));
    }

    public ApiResponse<List<Staking>> findByDateRange(@Param("startDate") LocalDateTime startDate,
                                                      @Param("endDate") LocalDateTime endDate) {
        return ApiResponse.ok(stakingRepository.findByDateRange(startDate, endDate));
    }

    public ApiResponse<List<Staking>> findByEventIdAndCryptoType(@Param("eventId") Long eventId,
                                                                 @Param("cryptoType") CryptoType cryptoType) {
        return ApiResponse.ok(stakingRepository.findByEventIdAndCryptoType(eventId, cryptoType));
    }

    public BigDecimal getTotalEarnedByUser(@Param("userId") Long userId) {
        return stakingRepository.getTotalEarnedByUser(userId);
    }

    public ApiResponse<List<Staking>> findAllOrderByStakeStart() {
        return ApiResponse.ok(stakingRepository.findAllOrderByStakeStart());
    }

    public long countByStakingEventId(@Param("eventId") Long eventId) {
        return stakingRepository.countByStakingEventId(eventId);
    }
}
