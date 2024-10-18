package com.pdp.PixelTrade.service.wallet;

import com.pdp.PixelTrade.dto.ApiResponse;
import com.pdp.PixelTrade.entity.wallet.Fee;
import com.pdp.PixelTrade.repository.wallet.FeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
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

    public Optional<Fee> findByTransactionId(@Param("transactionId") Long transactionId) {
        return feeRepository.findByTransactionId(transactionId);
    }

    public ApiResponse<List<Fee>> findByFeeRange(@Param("minFee") BigDecimal minFee,
                                                 @Param("maxFee") BigDecimal maxFee) {
        return ApiResponse.ok(feeRepository.findByFeeRange(minFee, maxFee));
    }

    public ApiResponse<List<Fee>> findByFeePercentageRange(@Param("minPercentage") BigDecimal minPercentage,
                                                           @Param("maxPercentage") BigDecimal maxPercentage) {
        return ApiResponse.ok(feeRepository.findByFeePercentageRange(minPercentage, maxPercentage));
    }

    public ApiResponse<List<Fee>> findActiveTransactionFees() {
        return ApiResponse.ok(feeRepository.findActiveTransactionFees());
    }

    public long countZeroPercentageFees() {
        return feeRepository.countZeroPercentageFees();
    }
}
