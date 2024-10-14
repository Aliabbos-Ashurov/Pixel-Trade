package com.pdp.PixelTrade.service.wallet;

import com.pdp.PixelTrade.dto.ApiResponse;
import com.pdp.PixelTrade.entity.wallet.CloudMining;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.enums.MiningStatus;
import com.pdp.PixelTrade.repository.wallet.CloudMiningRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
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

    public ApiResponse<List<CloudMining>> findByUserId(@Param("userId") Long userId) {
        return ApiResponse.ok(cloudMiningRepository.findByUserId(userId));
    }

    public ApiResponse<List<CloudMining>> findByUserIdAndStatus(@Param("userId") Long userId, @Param("status") MiningStatus status) {
        return ApiResponse.ok(cloudMiningRepository.findByUserIdAndStatus(userId, status));
    }

    public ApiResponse<List<CloudMining>> findByStatus(@Param("status") MiningStatus status) {
        return ApiResponse.ok(cloudMiningRepository.findByStatus(status));
    }

    public ApiResponse<List<CloudMining>> findByTimeRange(@Param("startTime") LocalDateTime startTime,
                                                          @Param("endTime") LocalDateTime endTime) {
        return ApiResponse.ok(cloudMiningRepository.findByTimeRange(startTime, endTime));
    }

    public ApiResponse<List<CloudMining>> findByCryptoType(@Param("cryptoType") CryptoType cryptoType) {
        return ApiResponse.ok(cloudMiningRepository.findByCryptoType(cryptoType));
    }

    public ApiResponse<List<CloudMining>> findByUserIdAndCryptoType(@Param("userId") Long userId,
                                                                    @Param("cryptoType") CryptoType cryptoType) {
        return ApiResponse.ok(cloudMiningRepository.findByUserIdAndCryptoType(userId, cryptoType));
    }

    long countByStatus(@Param("status") MiningStatus status) {
        return cloudMiningRepository.countByStatus(status);
    }
}
