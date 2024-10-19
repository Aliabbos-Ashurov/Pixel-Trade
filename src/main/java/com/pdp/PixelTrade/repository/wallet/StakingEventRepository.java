package com.pdp.PixelTrade.repository.wallet;

import com.pdp.PixelTrade.entity.wallet.StakingEvent;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.enums.StakingEventStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface StakingEventRepository extends JpaRepository<StakingEvent, Long> {
    @Query("""
            FROM StakingEvent se
            WHERE se.cryptoType = :cryptoType
            AND se.deleted = FALSE
            """)
    List<StakingEvent> findByCryptoType(@Param("cryptoType") CryptoType cryptoType);

    @Query("""
            FROM StakingEvent se
            WHERE se.eventStatus = :status
            AND se.deleted = FALSE
            """)
    List<StakingEvent> findByEventStatus( @Param("status") StakingEventStatus status);

    @Query("""
            FROM StakingEvent se
            WHERE se.startDate >= :startDate
            AND se.endDate <= :endDate
            AND se.deleted = FALSE
            """)
    List<StakingEvent> findEventsByDateRange(@Param("startDate") LocalDateTime startDate,
                                             @Param("endDate") LocalDateTime endDate);

    @Query("""
            FROM StakingEvent se
            WHERE se.cryptoType = :cryptoType
            AND se.eventStatus = :status
            AND se.deleted = FALSE
            """)
    List<StakingEvent> findByCryptoTypeAndStatus(@Param("cryptoType") CryptoType cryptoType,
                                                 @Param("status") StakingEventStatus status);

    @Query("""
            FROM StakingEvent se
            WHERE se.title LIKE %:keyword%
            AND se.deleted = FALSE
            """)
    List<StakingEvent> findByTitleContaining(@Param("keyword") String keyword);

    @Query("""
            FROM StakingEvent se
            WHERE se.description LIKE %:keyword%
            AND se.deleted = FALSE
            """)
    List<StakingEvent> findByDescriptionContaining(@Param("keyword") String keyword);

    @Query("""
            SELECT COUNT(se) FROM StakingEvent se
            WHERE se.eventStatus = :status
            AND se.deleted = FALSE
            """)
    long countByEventStatus(@Param("status") StakingEventStatus status);

    @Query("""
            FROM StakingEvent se WHERE se.title LIKE %:keyword%
            OR se.description LIKE %:keyword%
            AND se.deleted = FALSE
            """)
    List<StakingEvent> findByTitleOrDescriptionContaining(@Param("keyword") String keyword);

    @Query("""
            FROM StakingEvent se WHERE se.deleted = FALSE
            ORDER BY se.startDate ASC
            """)
    List<StakingEvent> findAllOrderByStartDate();
}