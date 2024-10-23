package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.entity.wallet.Staking;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.mapper.StakingMapper;
import com.pdp.PixelTrade.repository.StakingRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 14/October/2024  10:13
 **/
@Service
public class StakingService extends AbstractService<StakingRepository, StakingMapper> {

    public StakingService(StakingRepository repository, StakingMapper mapper) {
        super(repository, mapper);
    }

    public Response<List<Staking>> findByUserId(@NotNull Long userId) {
        return Response.ok(repository.findByUserId(userId));
    }

    public Response<List<Staking>> findByStakingEventId(@NotNull Long eventId) {
        return Response.ok(repository.findByStakingEventId(eventId));
    }

    public Response<List<Staking>> findByCryptoType(@NotNull CryptoType cryptoType) {
        return Response.ok(repository.findByCryptoType(cryptoType));
    }

    public Response<List<Staking>> findByUserIdAndEventId(@NotNull Long userId,
                                                          @NotNull Long eventId) {
        return Response.ok(repository.findByUserIdAndEventId(userId, eventId));
    }

    public Response<List<Staking>> findByDateRange(@NotNull LocalDateTime startDate,
                                                   @NotNull LocalDateTime endDate) {
        return Response.ok(repository.findByDateRange(startDate, endDate));
    }

    public Response<List<Staking>> findByEventIdAndCryptoType(@NotNull Long eventId,
                                                              @NotNull CryptoType cryptoType) {
        return Response.ok(repository.findByEventIdAndCryptoType(eventId, cryptoType));
    }

    public BigDecimal getTotalEarnedByUser(@NotNull Long userId) {
        return repository.getTotalEarnedByUser(userId);
    }

    public Response<List<Staking>> findAllOrderByStakeStart() {
        return Response.ok(repository.findAllOrderByStakeStart());
    }

    public long countByStakingEventId(@NotNull Long eventId) {
        return repository.countByStakingEventId(eventId);
    }
}
