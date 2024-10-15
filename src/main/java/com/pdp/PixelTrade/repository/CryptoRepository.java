package com.pdp.PixelTrade.repository;

import com.pdp.PixelTrade.entity.Crypto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface CryptoRepository extends JpaRepository<Crypto, Long> {

    Optional<Crypto> findByName(String name);

    Optional<Crypto> findBySymbol(String symbol);

    boolean existsBySymbol(String symbol);

    boolean existsByName(String name);

    @Query("""
            SELECT c
            FROM Crypto c
            WHERE c.deleted = FALSE
            ORDER BY c.feePercentage DESC
            """)
    List<Crypto> findAllOrderByFeePercentageDesc();

    @Modifying
    @Query("""
            UPDATE Crypto c
            SET c.feePercentage = :feePercentage
            WHERE c.id = :id
            AND c.deleted = FALSE
            """)
    void updateFeePercentage(@Param("id") Long id, @Param("feePercentage") BigDecimal feePercentage);
}