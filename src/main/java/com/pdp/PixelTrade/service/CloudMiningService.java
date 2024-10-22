package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.entity.wallet.CloudMining;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.enums.MiningStatus;
import com.pdp.PixelTrade.repository.wallet.CloudMiningRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 14/October/2024  11:37
 **/
@Service
@RequiredArgsConstructor
public class CloudMiningService {

    private final CloudMiningRepository cloudMiningRepository;

    public Response<List<CloudMining>> findByUserId(@NotNull Long userId) {
        return Response.ok(cloudMiningRepository.findByUserId(userId));
    }

    public Response<List<CloudMining>> findByUserIdAndStatus(@NotNull Long userId,
                                                             @NotNull MiningStatus status) {
        return Response.ok(cloudMiningRepository.findByUserIdAndStatus(userId, status));
    }

    public Response<List<CloudMining>> findByStatus(@NotNull MiningStatus status) {
        return Response.ok(cloudMiningRepository.findByStatus(status));
    }

    public Response<List<CloudMining>> findByTimeRange(@NotNull LocalDateTime startTime,
                                                       @NotNull LocalDateTime endTime) {
        return Response.ok(cloudMiningRepository.findByTimeRange(startTime, endTime));
    }

    public Response<List<CloudMining>> findByCryptoType(@NotNull CryptoType cryptoType) {
        return Response.ok(cloudMiningRepository.findByCryptoType(cryptoType));
    }

    public Response<List<CloudMining>> findByUserIdAndCryptoType(@NotNull Long userId,
                                                                 @NotNull CryptoType cryptoType) {
        return Response.ok(cloudMiningRepository.findByUserIdAndCryptoType(userId, cryptoType));
    }

    long countByStatus(@NotNull MiningStatus status) {
        return cloudMiningRepository.countByStatus(status);
    }
}
