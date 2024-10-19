package com.pdp.PixelTrade.repository.wallet;

import com.pdp.PixelTrade.entity.wallet.WalletSuspicionRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface WalletSuspicionRecordRepository extends JpaRepository<WalletSuspicionRecord, Long> {

    @Query("""
            FROM WalletSuspicionRecord wsr
            WHERE wsr.wallet.address = :address
            AND wsr.deleted = FALSE
            """)
    List<WalletSuspicionRecord> findByWalletAddress(@Param("address") String address);

    @Query("""
            SELECT COUNT(*) > 0 
            FROM WalletSuspicionRecord wsr
            WHERE wsr.wallet.address = :address
            AND wsr.deleted = FALSE
            """)
    boolean exists(@Param("address") String address);


    @Query("""
            FROM WalletSuspicionRecord wsr
            WHERE wsr.reason LIKE %:reason%
            AND wsr.deleted = FALSE
            """)
    List<WalletSuspicionRecord> findByReasonContaining(@Param("reason") String reason);

    @Query("""
            FROM WalletSuspicionRecord wsr
            WHERE wsr.createdAt BETWEEN :startDate AND :endDate
            AND wsr.deleted = FALSE
            """)
    List<WalletSuspicionRecord> findByCreatedAtRange(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate);

    @Query("""
            SELECT COUNT(wsr)
            FROM WalletSuspicionRecord wsr
            WHERE wsr.wallet.address = :address
            AND wsr.deleted = FALSE
            """)
    long countSuspectRecordsByWallet(@Param("address") String address);

}