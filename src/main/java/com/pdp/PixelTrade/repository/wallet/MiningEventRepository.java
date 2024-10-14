package com.pdp.PixelTrade.repository.wallet;

import com.pdp.PixelTrade.entity.wallet.MiningEvent;
import com.pdp.PixelTrade.enums.CryptoType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface MiningEventRepository extends JpaRepository<MiningEvent, Long> {
    @Query("""
            FROM MiningEvent me
            WHERE me.cryptoType = :cryptoType
            AND me.deleted = FALSE
            ORDER BY me.startTime DESC
            """)
    List<MiningEvent> findByCryptoType(@Param("cryptoType") CryptoType cryptoType);

    @Query("""
            FROM MiningEvent me
            WHERE me.startTime >= :start
            AND me.endTime <= :end
            AND me.deleted = FALSE
            """)
    List<MiningEvent> findByTimeRange(@Param("start") LocalDateTime start,
                                      @Param("end") LocalDateTime end);

    @Query("""
            FROM MiningEvent me
            WHERE me.startTime <= :currentTime
            AND me.endTime > :currentTime
            AND me.deleted = FALSE
            ORDER BY me.startTime DESC
            """)
    List<MiningEvent> findCurrentlyActiveEvents(@Param("currentTime") LocalDateTime currentTime);

    @Query("""
            FROM MiningEvent me
            WHERE me.endTime < :currentTime
            AND me.deleted = FALSE
            """)
    List<MiningEvent> findExpiredEvents(@Param("currentTime") LocalDateTime currentTime);

    @Query("""
            SELECT COUNT(me)
            FROM MiningEvent me
            WHERE me.cryptoType = :cryptoType
            AND me.deleted = FALSE
            """)
    long countByCryptoType(@Param("cryptoType") CryptoType cryptoType);

    @Query("""
            SELECT SUM(me.amount)
            FROM MiningEvent me
            WHERE me.cryptoType = :cryptoType
            AND me.deleted = FALSE
            """)
    BigDecimal getTotalAmountByCryptoType(@Param("cryptoType") CryptoType cryptoType);

}