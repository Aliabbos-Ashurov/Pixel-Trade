package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.entity.wallet.CloudMining;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.enums.MiningStatus;
import com.pdp.PixelTrade.mapper.CloudMiningMapper;
import com.pdp.PixelTrade.repository.CloudMiningRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 14/October/2024  11:37
 **/
@Service
public class CloudMiningService extends AbstractService<CloudMiningRepository, CloudMiningMapper> {

    public CloudMiningService(CloudMiningRepository repository, CloudMiningMapper mapper) {
        super(repository, mapper);
    }

    public Response<List<CloudMining>> findByUserId(@NotNull Long userId) {
        return Response.ok(repository.findByUserId(userId));
    }

    public Response<List<CloudMining>> findByUserIdAndStatus(@NotNull Long userId,
                                                             @NotNull MiningStatus status) {
        return Response.ok(repository.findByUserIdAndStatus(userId, status));
    }

    public Response<List<CloudMining>> findByStatus(@NotNull MiningStatus status) {
        return Response.ok(repository.findByStatus(status));
    }

    public Response<List<CloudMining>> findByTimeRange(@NotNull LocalDateTime startTime,
                                                       @NotNull LocalDateTime endTime) {
        return Response.ok(repository.findByTimeRange(startTime, endTime));
    }

    public Response<List<CloudMining>> findByCryptoType(@NotNull CryptoType cryptoType) {
        return Response.ok(repository.findByCryptoType(cryptoType));
    }

    public Response<List<CloudMining>> findByUserIdAndCryptoType(@NotNull Long userId,
                                                                 @NotNull CryptoType cryptoType) {
        return Response.ok(repository.findByUserIdAndCryptoType(userId, cryptoType));
    }

    long countByStatus(@NotNull MiningStatus status) {
        return repository.countByStatus(status);
    }
}
