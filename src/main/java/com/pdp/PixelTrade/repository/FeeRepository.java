package com.pdp.PixelTrade.repository;

import com.pdp.PixelTrade.entity.wallet.Fee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface FeeRepository extends JpaRepository<Fee, Long> {

    @Query("""
            FROM Fee f
            WHERE f.transaction.id = :transactionId
            AND f.deleted = FALSE
            """)
    Optional<Fee> findByTransactionId(@Param("transactionId") Long transactionId);

    @Query("""
            FROM Fee f
            WHERE f.fee BETWEEN :minFee AND :maxFee
            AND f.deleted = FALSE
            """)
    List<Fee> findByFeeRange(@Param("minFee") BigDecimal minFee,
                             @Param("maxFee") BigDecimal maxFee);

    @Query("""
            FROM Fee f
            WHERE f.feePercentage BETWEEN :minPercentage AND :maxPercentage
            AND f.deleted = FALSE
            """)
    List<Fee> findByFeePercentageRange(@Param("minPercentage") BigDecimal minPercentage,
                                       @Param("maxPercentage") BigDecimal maxPercentage);

    @Query("""
            FROM Fee f
            WHERE f.transaction.deleted = FALSE
            AND f.deleted = FALSE
            """)
    List<Fee> findActiveTransactionFees();
}