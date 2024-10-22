package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.entity.wallet.Fee;
import com.pdp.PixelTrade.mapper.FeeMapper;
import com.pdp.PixelTrade.repository.wallet.FeeRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * @author Aliabbos Ashurov
 * @since 14/October/2024  11:30
 **/
@Service
public class FeeService extends AbstractService<FeeRepository, FeeMapper> {

    public FeeService(FeeRepository repository, FeeMapper mapper) {
        super(repository, mapper);
    }

    public Fee saveFee(Fee fee) {
        return repository.save(fee);
    }

    public Optional<Fee> findByTransactionId(@NotNull Long transactionId) {
        return repository.findByTransactionId(transactionId);
    }

    public Response<List<Fee>> findByFeeRange(@NotNull BigDecimal minFee,
                                              @NotNull BigDecimal maxFee) {
        return Response.ok(repository.findByFeeRange(minFee, maxFee));
    }

    public Response<List<Fee>> findByFeePercentageRange(@NotNull BigDecimal minPercentage,
                                                        @NotNull BigDecimal maxPercentage) {
        return Response.ok(repository.findByFeePercentageRange(minPercentage, maxPercentage));
    }

    public Response<List<Fee>> findActiveTransactionFees() {
        return Response.ok(repository.findActiveTransactionFees());
    }
}
