package com.pdp.PixelTrade.service.wallet;

import com.pdp.PixelTrade.dto.Response;
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

    public Response<List<Staking>> findByUserId(@NotNull Long userId) {
        return Response.ok(stakingRepository.findByUserId(userId));
    }

    public Response<List<Staking>> findByStakingEventId(@NotNull Long eventId) {
        return Response.ok(stakingRepository.findByStakingEventId(eventId));
    }

    public Response<List<Staking>> findByCryptoType(@NotNull CryptoType cryptoType) {
        return Response.ok(stakingRepository.findByCryptoType(cryptoType));
    }

    public Response<List<Staking>> findByUserIdAndEventId(@NotNull Long userId,
                                                          @NotNull Long eventId) {
        return Response.ok(stakingRepository.findByUserIdAndEventId(userId, eventId));
    }

    public Response<List<Staking>> findByDateRange(@NotNull LocalDateTime startDate,
                                                   @NotNull LocalDateTime endDate) {
        return Response.ok(stakingRepository.findByDateRange(startDate, endDate));
    }

    public Response<List<Staking>> findByEventIdAndCryptoType(@NotNull Long eventId,
                                                              @NotNull CryptoType cryptoType) {
        return Response.ok(stakingRepository.findByEventIdAndCryptoType(eventId, cryptoType));
    }

    public BigDecimal getTotalEarnedByUser(@NotNull Long userId) {
        return stakingRepository.getTotalEarnedByUser(userId);
    }

    public Response<List<Staking>> findAllOrderByStakeStart() {
        return Response.ok(stakingRepository.findAllOrderByStakeStart());
    }

    public long countByStakingEventId(@NotNull Long eventId) {
        return stakingRepository.countByStakingEventId(eventId);
    }
}
