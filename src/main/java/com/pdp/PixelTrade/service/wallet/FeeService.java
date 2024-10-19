package com.pdp.PixelTrade.service.wallet;

import com.pdp.PixelTrade.dto.ApiResponse;
import com.pdp.PixelTrade.entity.wallet.Fee;
import com.pdp.PixelTrade.repository.wallet.FeeRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * @author Aliabbos Ashurov
 * @since 14/October/2024  11:30
 **/
@Service
@RequiredArgsConstructor
public class FeeService {

    private final FeeRepository feeRepository;

    public Fee saveFee(Fee fee) {
        return feeRepository.save(fee);
    }

    public Optional<Fee> findByTransactionId(@NotNull Long transactionId) {
        return feeRepository.findByTransactionId(transactionId);
    }

    public ApiResponse<List<Fee>> findByFeeRange(@NotNull BigDecimal minFee,
                                                 @NotNull BigDecimal maxFee) {
        return ApiResponse.ok(feeRepository.findByFeeRange(minFee, maxFee));
    }

    public ApiResponse<List<Fee>> findByFeePercentageRange(@NotNull BigDecimal minPercentage,
                                                           @NotNull BigDecimal maxPercentage) {
        return ApiResponse.ok(feeRepository.findByFeePercentageRange(minPercentage, maxPercentage));
    }

    public ApiResponse<List<Fee>> findActiveTransactionFees() {
        return ApiResponse.ok(feeRepository.findActiveTransactionFees());
    }
}
