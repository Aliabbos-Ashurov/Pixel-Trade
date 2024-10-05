package com.pdp.PixelTrade.repository;

import com.pdp.PixelTrade.entity.transactions.CryptoAsset;
import com.pdp.PixelTrade.enums.CryptoType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface CryptoAssetRepository extends JpaRepository<CryptoAsset, Long> {

    @Query("FROM CryptoAsset ca WHERE ca.wallet.id = :walletId AND ca.deleted = FALSE")
    List<CryptoAsset> findAllByWalletId(@Param("walletId") Long walletId);

    @Query("FROM CryptoAsset ca WHERE ca.wallet.id = :walletId AND ca.isLocked = TRUE AND ca.deleted = FALSE")
    List<CryptoAsset> findLockedAssetsByWalletId(@Param("walletId") Long walletId);

    @Query("SELECT ca.amount FROM CryptoAsset ca WHERE ca.id = :cryptoId AND ca.deleted = FALSE")
    BigDecimal getTotalCryptoById(@Param("cryptoId") Long cryptoId);

    @Query("FROM CryptoAsset ca WHERE ca.wallet.id = :walletId AND ca.cryptoType = :cryptoType AND ca.deleted = FALSE")
    Optional<CryptoAsset> findByWalletIdAndCryptoType(@Param("walletId") Long walletId, @Param("cryptoType") CryptoType cryptoType);

    @Modifying
    @Query("UPDATE CryptoAsset ca SET ca.isLocked = TRUE, ca.lockedReason = :reason WHERE ca.id = :assetId AND ca.deleted = FALSE")
    void lockCryptoAsset(@Param("assetId") Long assetId, @Param("reason") String reason);

    @Modifying
    @Query("UPDATE CryptoAsset ca SET ca.isLocked = FALSE, ca.lockedReason = NULL WHERE ca.id = :assetId AND ca.deleted = FALSE")
    void unlockCryptoAsset(@Param("assetId") Long assetId);

    @Query("SELECT ca.isLocked FROM CryptoAsset ca WHERE ca.id = :assetId AND ca.deleted = FALSE")
    boolean isCryptoAssetLocked(@Param("assetId") Long assetId);

}