package com.pdp.PixelTrade.repository;

import com.pdp.PixelTrade.entity.wallet.Wallet;
import com.pdp.PixelTrade.enums.IdentificationLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author Aliabbos Ashurov
 * @since 05/October/2024  11:09
 **/
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    @Query("""
            SELECT (w.balance + COALESCE(SUM(ca.amount), 0)) AS totalBalance
            FROM Wallet w
            LEFT JOIN w.cryptoAssets ca
            WHERE w.address = :address
            AND w.deleted = FALSE
            AND (ca.deleted = FALSE OR ca IS NULL)
            GROUP BY w.address
            """)
    BigDecimal getBalance(@Param("address") String address);


    @Query("""
            FROM Wallet w
            WHERE w.address = :address
            AND w.deleted = FALSE
            """)
    Optional<Wallet> findByAddress(@Param("address") String address);

    @Query("""
            FROM Wallet w
            WHERE w.id = :id
            AND w.deleted = FALSE
            """)
    Optional<Wallet> findByWalletId(@Param("id") Long id);

    @Query("""
            SELECT COUNT(w)
            FROM Wallet w
            WHERE w.level = :level
            AND w.deleted = FALSE
            """)
    Long countWalletsByIdentificationLevel(@Param("level") IdentificationLevel level);

    @Modifying
    @Query("""
            UPDATE Wallet w
            SET w.balance = w.balance + :amount
            WHERE w.address = :address
            AND w.deleted = FALSE
            """)
    void addBalance(@Param("address") String address, @Param("amount") BigDecimal amount);

    @Modifying
    @Query("""
            UPDATE Wallet w
            SET w.balance = w.balance - :amount
            WHERE w.address = :address
            AND w.deleted = FALSE
            AND w.balance >= :amount
            """)
    void subtractBalance(@Param("address") String address, @Param("amount") BigDecimal amount);

    @Modifying
    @Query("""
            UPDATE CryptoAsset ca
            SET ca.isLocked = TRUE, ca.lockedReason = :reason
            WHERE ca.wallet.id = :walletId
            """)
    void lockAllAssetsInWallet(@Param("reason") String reason, @Param("walletId") Long walletId);

    @Modifying
    @Query("""
            UPDATE CryptoAsset ca
            SET ca.isLocked = FALSE, ca.lockedReason = NULL
            WHERE ca.wallet.id = :walletId
            """)
    void unlockAllAssetsInWallet(@Param("walletId") Long walletId);

    @Query("""
            SELECT CASE WHEN COUNT(ca) > 0
            THEN TRUE ELSE FALSE END
            FROM CryptoAsset ca
            WHERE ca.wallet.id = :walletId
            AND ca.isLocked = TRUE
            """)
    boolean hasLockedAssets(@Param("walletId") Long walletId);

}
