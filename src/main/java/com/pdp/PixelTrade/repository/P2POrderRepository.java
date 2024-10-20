package com.pdp.PixelTrade.repository;

import com.pdp.PixelTrade.entity.wallet.P2POrder;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.enums.P2POrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface P2POrderRepository extends JpaRepository<P2POrder, Long> {

    @Query("""
            FROM P2POrder o
            WHERE o.cryptoType = :cryptoType
            AND o.deleted = FALSE
            """)
    List<P2POrder> findByCryptoType(@Param("cryptoType") CryptoType cryptoType);

    @Query("""
            FROM P2POrder o
            WHERE o.orderStatus = :status
            AND o.deleted = FALSE
            """)
    List<P2POrder> findByStatus(@Param("status") P2POrderStatus status);

    @Query("""
            FROM P2POrder o
            WHERE o.wallet.id = :walletId
            AND o.deleted = FALSE
            """)
    List<P2POrder> findByWalletId(@Param("walletId") Long walletId);
}