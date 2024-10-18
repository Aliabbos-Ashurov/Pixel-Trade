package com.pdp.PixelTrade.repository.wallet;

import com.pdp.PixelTrade.entity.wallet.CryptoAsset;
import com.pdp.PixelTrade.enums.CryptoType;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CryptoAssetRepository extends JpaRepository<CryptoAsset, Long> {

    @Query("""
            FROM CryptoAsset ca
            WHERE ca.wallet.address = :address
            AND ca.deleted = FALSE
            """)
    List<CryptoAsset> findAllByWalletAddress(@NotNull @Param("address") String address);

    @Query("""
            FROM CryptoAsset ca
            WHERE ca.wallet.address = :address
            AND ca.cryptoType = :type
            AND ca.deleted = FALSE
            """)
    Optional<CryptoAsset> find(@Param("address") String address, @Param("type") CryptoType type);

    @Query("""
            FROM CryptoAsset ca
            WHERE ca.wallet.address = :address
            AND ca.isLocked = TRUE
            AND ca.deleted = FALSE
            """)
    List<CryptoAsset> findLockedAssetsByWalletAddress(@NotNull @Param("address") String address);


    @Query("""
            FROM CryptoAsset ca
            WHERE ca.wallet.address = :address
            AND ca.wallet.deleted = FALSE
            AND ca.cryptoType = :cryptoType
            AND ca.deleted = FALSE
            """)
    Optional<CryptoAsset> findByWalletAddressAndCryptoType(@Param("address") String address, @Param("cryptoType") CryptoType cryptoType);

    @Modifying
    @Query("""
            UPDATE CryptoAsset ca
            SET ca.isLocked = TRUE, ca.lockedReason = :reason
            WHERE ca.id = :assetId
            AND ca.deleted = FALSE
            """)
    void lockCryptoAsset(@Param("reason") String reason, @Param("assetId") Long assetId);

    @Modifying
    @Query("""
            UPDATE CryptoAsset ca
            SET ca.isLocked = FALSE, ca.lockedReason = NULL
            WHERE ca.id = :assetId
            AND ca.deleted = FALSE
            """)
    void unlockCryptoAsset(@Param("assetId") Long assetId);

    @Query("""
            SELECT ca.isLocked
            FROM CryptoAsset ca
            WHERE ca.id = :assetId
            AND ca.deleted = FALSE
            """)
    boolean isCryptoAssetLocked(@Param("assetId") Long assetId);

}