package com.pdp.PixelTrade.repository;

import com.pdp.PixelTrade.entity.Crypto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CryptoRepository extends JpaRepository<Crypto, Long> {

    @Query("""
            SELECT c.feePercentage
            FROM Crypto c
            WHERE c.symbol = :symbol
            AND c.deleted = FALSE
            """)
    Optional<BigDecimal> getFeePercentage(@Param("symbol") String symbol);


    @Query("""
            FROM Crypto c
            WHERE c.deleted = FALSE
            """)
    List<Crypto> findAllCustom();

    @Query("""
            SELECT c.symbol, c.price
            FROM Crypto c
            WHERE c.symbol IN :cryptoTypes
            """)
    List<Object[]> findPricesByCryptoTypes(@Param("cryptoTypes") Set<String> cryptoTypes);

    Optional<Crypto> findByName(String name);

    Optional<Crypto> findBySymbol(String symbol);

    @Modifying
    @Query("""
            UPDATE Crypto c
            SET c.feePercentage = :feePercentage
            WHERE c.id = :id
            AND c.deleted = FALSE
            """)
    void updateFeePercentage(@Param("id") Long id, @Param("feePercentage") BigDecimal feePercentage);

}