package com.pdp.PixelTrade.repository;

import com.pdp.PixelTrade.entity.wallet.Staking;
import com.pdp.PixelTrade.enums.CryptoType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface StakingRepository extends JpaRepository<Staking, Long> {

    @Query("""
            FROM Staking s
            WHERE s.user.id = :userId
            AND s.deleted = FALSE
            """)
    List<Staking> findByUserId(@Param("userId") Long userId);

    @Query("""
            FROM Staking s
            WHERE s.stakingEvent.id = :eventId
            AND s.deleted = FALSE
            """)
    List<Staking> findByStakingEventId(@Param("eventId") Long eventId);

    @Query("""
            FROM Staking s
            WHERE s.cryptoType = :cryptoType
            AND s.deleted = FALSE
            """)
    List<Staking> findByCryptoType(@Param("cryptoType") CryptoType cryptoType);

    @Query("""
            FROM Staking s 
            WHERE s.stakeEnd IS NOT NULL
            AND s.deleted = FALSE
            """)
    List<Staking> findEndedStakes();

    @Query("""
            FROM Staking s
            WHERE s.stakeEnd IS NULL
            AND s.stakeEnd > CURRENT_TIMESTAMP
            AND s.deleted = FALSE
            """)
    List<Staking> findActiveStakes();

    @Query("""
            FROM Staking s
            WHERE s.user.id = :userId
            AND s.stakingEvent.id = :eventId
            AND s.deleted = FALSE
            """)
    List<Staking> findByUserIdAndEventId(@Param("userId") Long userId,
                                         @Param("eventId") Long eventId);

    @Query("""
            FROM Staking s
            WHERE s.stakeStart >= :startDate
            AND s.stakeStart <= :endDate
            AND s.deleted = FALSE
            """)
    List<Staking> findByDateRange(@Param("startDate") LocalDateTime startDate,
                                  @Param("endDate") LocalDateTime endDate);

    @Query("""
            FROM Staking s WHERE s.stakingEvent.id = :eventId
            AND s.cryptoType = :cryptoType
            AND s.deleted = FALSE
            """)
    List<Staking> findByEventIdAndCryptoType(@Param("eventId") Long eventId,
                                             @Param("cryptoType") CryptoType cryptoType);

    @Query("""
            SELECT SUM(s.earned)
            FROM Staking s
            WHERE s.user.id = :userId
            AND s.deleted = FALSE
            """)
    BigDecimal getTotalEarnedByUser(@Param("userId") Long userId);

    @Query("""
            FROM Staking s
            WHERE  s.deleted = FALSE
            ORDER BY s.stakeStart ASC
            """)
    List<Staking> findAllOrderByStakeStart();

    @Query("""
            SELECT COUNT(s)
            FROM Staking s
            WHERE s.stakingEvent.id = :eventId
            AND s.deleted = FALSE
            AND s.stakingEvent.deleted = FALSE
            """)
    long countByStakingEventId(@Param("eventId") Long eventId);
}