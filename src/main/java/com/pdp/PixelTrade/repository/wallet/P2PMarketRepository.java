package com.pdp.PixelTrade.repository.wallet;

import com.pdp.PixelTrade.entity.wallet.P2PMarket;
import com.pdp.PixelTrade.enums.CryptoType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface P2PMarketRepository extends JpaRepository<P2PMarket, Long> {

    @Query("""
            FROM P2PMarket pm
            WHERE pm.seller.id = :sellerId
            AND pm.deleted = FALSE
            """)
    List<P2PMarket> findByOwnerId(@Param("sellerId") Long sellerId);

    @Query("""
            FROM P2PMarket pm
            WHERE pm.cryptoType = :cryptoType
            AND pm.deleted = FALSE
            """)
    List<P2PMarket> findByCryptoType(@Param("cryptoType") CryptoType cryptoType);
}