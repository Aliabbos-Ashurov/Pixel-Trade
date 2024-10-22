package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.entity.wallet.MiningEvent;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.mapper.MiningEventMapper;
import com.pdp.PixelTrade.repository.wallet.MiningEventRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 14/October/2024  11:27
 **/
@Service
public class MiningEventService extends AbstractService<MiningEventRepository, MiningEventMapper> {

    public MiningEventService(MiningEventRepository repository, MiningEventMapper mapper) {
        super(repository, mapper);
    }

    public Response<List<MiningEvent>> findByCryptoType(@NotNull CryptoType cryptoType) {
        return Response.ok(repository.findByCryptoType(cryptoType));
    }

    public Response<List<MiningEvent>> findByTimeRange(@NotNull LocalDateTime start,
                                                       @NotNull LocalDateTime end) {
        return Response.ok(repository.findByTimeRange(start, end));
    }

    public Response<List<MiningEvent>> findCurrentlyActiveEvents(@NotNull LocalDateTime currentTime) {
        return Response.ok(repository.findCurrentlyActiveEvents(currentTime));
    }

    public Response<List<MiningEvent>> findExpiredEvents(@NotNull LocalDateTime currentTime) {
        return Response.ok(repository.findExpiredEvents(currentTime));
    }

    public long countByCryptoType(@NotNull CryptoType cryptoType) {
        return repository.countByCryptoType(cryptoType);
    }

    public BigDecimal getTotalAmountByCryptoType(@NotNull CryptoType cryptoType) {
        return repository.getTotalAmountByCryptoType(cryptoType);
    }
}
