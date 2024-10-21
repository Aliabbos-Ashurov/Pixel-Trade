package com.pdp.PixelTrade.service.wallet;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.entity.wallet.StakingEvent;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.enums.StakingEventStatus;
import com.pdp.PixelTrade.repository.wallet.StakingEventRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 14/October/2024  10:17
 **/
@Service
@RequiredArgsConstructor
public class StakingEventService {
    private final StakingEventRepository stakingEventRepository;

    public Response<List<StakingEvent>> findByCryptoType(@NotNull CryptoType cryptoType) {
        return Response.ok(stakingEventRepository.findByCryptoType(cryptoType));
    }

    public Response<List<StakingEvent>> findByEventStatus(@NotNull StakingEventStatus status) {
        return Response.ok(stakingEventRepository.findByEventStatus(status));
    }

    public Response<List<StakingEvent>> findEventsByDateRange(@NotNull LocalDateTime startDate,
                                                              @NotNull LocalDateTime endDate) {
        return Response.ok(stakingEventRepository.findEventsByDateRange(startDate, endDate));
    }

    public Response<List<StakingEvent>> findByCryptoTypeAndStatus(@NotNull CryptoType cryptoType,
                                                                  @NotNull StakingEventStatus status) {
        return Response.ok(stakingEventRepository.findByCryptoTypeAndStatus(cryptoType, status));
    }

    public Response<List<StakingEvent>> findByTitleContaining(@NotNull String keyword) {
        return Response.ok(stakingEventRepository.findByTitleContaining(keyword));
    }

    public Response<List<StakingEvent>> findByDescriptionContaining(@NotNull String keyword) {
        return Response.ok(stakingEventRepository.findByDescriptionContaining(keyword));
    }

    public long countByEventStatus(@Param("status") StakingEventStatus status) {
        return stakingEventRepository.countByEventStatus(status);
    }

    public Response<List<StakingEvent>> findByTitleOrDescriptionContaining(@NotNull String keyword) {
        return Response.ok(stakingEventRepository.findByTitleOrDescriptionContaining(keyword));
    }

    public Response<List<StakingEvent>> findAllOrderByStartDate() {
        return Response.ok(stakingEventRepository.findAllOrderByStartDate());
    }
}
