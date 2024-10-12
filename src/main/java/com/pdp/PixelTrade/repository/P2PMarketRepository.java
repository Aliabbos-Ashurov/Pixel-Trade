package com.pdp.PixelTrade.repository;

import com.pdp.PixelTrade.entity.wallet.P2PMarket;
import com.pdp.PixelTrade.enums.CardType;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.enums.CurrencyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface P2PMarketRepository extends JpaRepository<P2PMarket, Long> {

    @Query("""
            FROM P2PMarket pm
            WHERE pm.owner.id = :ownerId
            AND pm.deleted = FALSE
            """)
    List<P2PMarket> findByOwnerId(@Param("ownerId") Long ownerId);

    @Query("""
            FROM P2PMarket pm
            WHERE pm.cryptoType = :cryptoType
            AND pm.deleted = FALSE
            """)
    List<P2PMarket> findByCryptoType(@Param("cryptoType") CryptoType cryptoType);

    @Query("""
            FROM P2PMarket pm
            WHERE pm.currencyType = :currencyType
            AND pm.deleted = FALSE
            """)
    List<P2PMarket> findByCurrencyType(@Param("currencyType") CurrencyType currencyType);


    @Query("""
            FROM P2PMarket pm
            WHERE pm.cryptoType = :cryptoType
            AND pm.currencyType = :currencyType
            AND pm.deleted = FALSE
            """)
    List<P2PMarket> findByCryptoAndCurrency(@Param("cryptoType") CryptoType cryptoType,
                                            @Param("currencyType") CurrencyType currencyType);

    @Query("""
            FROM P2PMarket pm
            WHERE pm.description LIKE %:keyword%
            AND pm.deleted = FALSE
            """)
    List<P2PMarket> findByDescriptionContaining(@Param("keyword") String keyword);

    @Query("""
            FROM P2PMarket pm
            WHERE pm.perPrice BETWEEN :minPrice
            AND :maxPrice
            AND pm.deleted = FALSE
            """)
    List<P2PMarket> findByPriceRange(@Param("minPrice") BigDecimal minPrice,
                                     @Param("maxPrice") BigDecimal maxPrice);

    @Query("""
            FROM P2PMarket pm
            WHERE pm.amount >= :minAmount
            AND pm.deleted = FALSE
            """)
    List<P2PMarket> findByMinAmount(@Param("minAmount") BigDecimal minAmount);

    @Query("""
            FROM P2PMarket pm
            WHERE pm.cryptoType = :cryptoType
            AND pm.cardType = :cardType
            AND pm.amount >= :amount
            AND pm.deleted = FALSE
            """)
    List<P2PMarket> findByCryptoCardTypeAndMinAmount(@Param("cryptoType") CryptoType cryptoType,
                                                     @Param("cardType") CardType cardType,
                                                     @Param("amount") BigDecimal amount);

    @Query("""
            SELECT COUNT(pm)
            FROM P2PMarket pm
            WHERE pm.cryptoType = :cryptoType
            AND pm.deleted = FALSE
            """)
    long countByCryptoType(@Param("cryptoType") CryptoType cryptoType);

}