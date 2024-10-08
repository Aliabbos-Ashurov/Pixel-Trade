package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.request.transaction.CryptoAssetCreationDTO;
import com.pdp.PixelTrade.dto.response.transaction.CryptoAssetDTO;
import com.pdp.PixelTrade.entity.transaction.CryptoAsset;
import com.pdp.PixelTrade.entity.transaction.Wallet;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.exceptions.ResourceNotFoundException;
import com.pdp.PixelTrade.exceptions.transaction.WalletNotFoundException;
import com.pdp.PixelTrade.mapper.CryptoAssetMapper;
import com.pdp.PixelTrade.repository.CryptoAssetRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 05/October/2024  12:40
 **/
@Service
@RequiredArgsConstructor
public class CryptoAssetService {

    private final WalletService walletService;
    private final CryptoAssetRepository cryptoAssetRepository;
    private final CryptoAssetMapper cryptoAssetMapper;

    @Transactional
    public void createCryptoAsset(CryptoAssetCreationDTO dto) {
        Wallet wallet = walletService.findByAddress(dto.walletAddress());
        if (wallet == null)
            throw new WalletNotFoundException("Wallet not found by address: {0}", dto.walletAddress());
        cryptoAssetRepository.save(CryptoAsset.builder()
                .wallet(wallet)
                .amount(dto.amount())
                .cryptoType(dto.cryptoType())
                .build());
    }

    public List<CryptoAssetDTO> findAllByWalletId(@NotNull Long walletId) {
        return cryptoAssetRepository.findAllByWalletId(walletId).stream()
                .map(cryptoAssetMapper::toCryptoAssetDTO)
                .toList();
    }

    public List<CryptoAssetDTO> findLockedAssetsByWalletId(@NotNull Long walletId) {
        return cryptoAssetRepository.findLockedAssetsByWalletId(walletId).stream()
                .map(cryptoAssetMapper::toCryptoAssetDTO)
                .toList();
    }

    public BigDecimal getTotalCryptoById(@NotNull Long cryptoId) {
        return cryptoAssetRepository.getTotalCryptoById(cryptoId);
    }

    public CryptoAssetDTO findByWalletIdAndCryptoType(@NotNull Long walletId, @NotNull CryptoType cryptoType) {
        CryptoAsset cryptoAsset = cryptoAssetRepository.findByWalletIdAndCryptoType(walletId, cryptoType).orElseThrow(
                () -> new ResourceNotFoundException("CryptoAsset not found by walletId {0} and type {1}", walletId, cryptoType)
        );
        return cryptoAssetMapper.toCryptoAssetDTO(cryptoAsset);
    }

    public void lockCryptoAsset(@NotNull Long assetId, @NotNull String reason) {
        cryptoAssetRepository.lockCryptoAsset(reason, assetId);
    }

    public void unlockCryptoAsset(@NotNull Long assetId) {
        cryptoAssetRepository.unlockCryptoAsset(assetId);
    }

    public boolean isCryptoAssetLocked(@NotNull Long assetId) {
        return cryptoAssetRepository.isCryptoAssetLocked(assetId);
    }
}
