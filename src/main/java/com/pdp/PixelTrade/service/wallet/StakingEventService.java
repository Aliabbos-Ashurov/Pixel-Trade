package com.pdp.PixelTrade.service.wallet;

import com.pdp.PixelTrade.dto.ApiResponse;
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

    public ApiResponse<List<StakingEvent>> findByCryptoType(@NotNull CryptoType cryptoType) {
        return ApiResponse.ok(stakingEventRepository.findByCryptoType(cryptoType));
    }

    public ApiResponse<List<StakingEvent>> findByEventStatus(@NotNull StakingEventStatus status) {
        return ApiResponse.ok(stakingEventRepository.findByEventStatus(status));
    }

    public ApiResponse<List<StakingEvent>> findEventsByDateRange(@NotNull LocalDateTime startDate,
                                                                 @NotNull LocalDateTime endDate) {
        return ApiResponse.ok(stakingEventRepository.findEventsByDateRange(startDate, endDate));
    }

    public ApiResponse<List<StakingEvent>> findByCryptoTypeAndStatus(@NotNull CryptoType cryptoType,
                                                                     @NotNull StakingEventStatus status) {
        return ApiResponse.ok(stakingEventRepository.findByCryptoTypeAndStatus(cryptoType, status));
    }

    public ApiResponse<List<StakingEvent>> findByTitleContaining(@NotNull String keyword) {
        return ApiResponse.ok(stakingEventRepository.findByTitleContaining(keyword));
    }

    public ApiResponse<List<StakingEvent>> findByDescriptionContaining(@NotNull String keyword) {
        return ApiResponse.ok(stakingEventRepository.findByDescriptionContaining(keyword));
    }

    public long countByEventStatus(@Param("status") StakingEventStatus status) {
        return stakingEventRepository.countByEventStatus(status);
    }

    public ApiResponse<List<StakingEvent>> findByTitleOrDescriptionContaining(@NotNull String keyword) {
        return ApiResponse.ok(stakingEventRepository.findByTitleOrDescriptionContaining(keyword));
    }

    public ApiResponse<List<StakingEvent>> findAllOrderByStartDate() {
        return ApiResponse.ok(stakingEventRepository.findAllOrderByStartDate());
    }
}
