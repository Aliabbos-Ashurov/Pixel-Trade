package com.pdp.PixelTrade.service.wallet;

import com.pdp.PixelTrade.dto.Response;
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

    public Response<List<Fee>> findByFeeRange(@NotNull BigDecimal minFee,
                                              @NotNull BigDecimal maxFee) {
        return Response.ok(feeRepository.findByFeeRange(minFee, maxFee));
    }

    public Response<List<Fee>> findByFeePercentageRange(@NotNull BigDecimal minPercentage,
                                                        @NotNull BigDecimal maxPercentage) {
        return Response.ok(feeRepository.findByFeePercentageRange(minPercentage, maxPercentage));
    }

    public Response<List<Fee>> findActiveTransactionFees() {
        return Response.ok(feeRepository.findActiveTransactionFees());
    }
}
