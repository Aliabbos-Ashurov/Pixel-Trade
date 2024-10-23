package com.pdp.PixelTrade.repository;

import com.pdp.PixelTrade.entity.wallet.CloudMining;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.enums.MiningStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface CloudMiningRepository extends JpaRepository<CloudMining, Long> {

    @Query("""
            FROM CloudMining cm
            WHERE cm.user.id = :userId
            AND cm.deleted = FALSE
            """)
    List<CloudMining> findByUserId(@Param("userId") Long userId);

    @Query("""
            FROM CloudMining cm
            WHERE cm.user.id = :userId
            AND cm.status = :status
            AND cm.deleted = FALSE
            """)
    List<CloudMining> findByUserIdAndStatus(@Param("userId") Long userId, @Param("status") MiningStatus status);

    @Query("""
            FROM CloudMining cm
            WHERE cm.status = :status
            AND cm.deleted = FALSE
            """)
    List<CloudMining> findByStatus(@Param("status") MiningStatus status);

    @Query("""
            FROM CloudMining cm
            WHERE cm.startedTime >= :startTime
            AND cm.startedTime <= :endTime
            AND cm.deleted = FALSE
            """)
    List<CloudMining> findByTimeRange(@Param("startTime") LocalDateTime startTime,
                                      @Param("endTime") LocalDateTime endTime);

    @Query("""
            FROM CloudMining cm
            WHERE cm.miningEvent.cryptoType = :cryptoType
            AND cm.deleted = FALSE
            """)
    List<CloudMining> findByCryptoType(@Param("cryptoType") CryptoType cryptoType);

    @Query("""
            SELECT COUNT(cm) FROM
            CloudMining cm WHERE cm.status = :status
            AND cm.deleted = FALSE
            """)
    long countByStatus(@Param("status") MiningStatus status);

    @Query("""
            FROM CloudMining cm
            WHERE cm.user.id = :userId
            AND cm.miningEvent.cryptoType = :cryptoType
            AND cm.deleted = FALSE
            """)
    List<CloudMining> findByUserIdAndCryptoType(@Param("userId") Long userId,
                                                @Param("cryptoType") CryptoType cryptoType);
}