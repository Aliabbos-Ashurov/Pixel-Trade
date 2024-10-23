package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.entity.wallet.StakingEvent;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.enums.StakingEventStatus;
import com.pdp.PixelTrade.mapper.StakingEventMapper;
import com.pdp.PixelTrade.repository.StakingEventRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 14/October/2024  10:17
 **/
@Service
public class StakingEventService extends AbstractService<StakingEventRepository, StakingEventMapper> {

    public StakingEventService(StakingEventRepository repository, StakingEventMapper mapper) {
        super(repository, mapper);
    }

    public Response<List<StakingEvent>> findByCryptoType(@NotNull CryptoType cryptoType) {
        return Response.ok(repository.findByCryptoType(cryptoType));
    }

    public Response<List<StakingEvent>> findByEventStatus(@NotNull StakingEventStatus status) {
        return Response.ok(repository.findByEventStatus(status));
    }

    public Response<List<StakingEvent>> findEventsByDateRange(@NotNull LocalDateTime startDate,
                                                              @NotNull LocalDateTime endDate) {
        return Response.ok(repository.findEventsByDateRange(startDate, endDate));
    }

    public Response<List<StakingEvent>> findByCryptoTypeAndStatus(@NotNull CryptoType cryptoType,
                                                                  @NotNull StakingEventStatus status) {
        return Response.ok(repository.findByCryptoTypeAndStatus(cryptoType, status));
    }

    public Response<List<StakingEvent>> findByTitleContaining(@NotNull String keyword) {
        return Response.ok(repository.findByTitleContaining(keyword));
    }

    public Response<List<StakingEvent>> findByDescriptionContaining(@NotNull String keyword) {
        return Response.ok(repository.findByDescriptionContaining(keyword));
    }

    public long countByEventStatus(@Param("status") StakingEventStatus status) {
        return repository.countByEventStatus(status);
    }

    public Response<List<StakingEvent>> findByTitleOrDescriptionContaining(@NotNull String keyword) {
        return Response.ok(repository.findByTitleOrDescriptionContaining(keyword));
    }

    public Response<List<StakingEvent>> findAllOrderByStartDate() {
        return Response.ok(repository.findAllOrderByStartDate());
    }
}
