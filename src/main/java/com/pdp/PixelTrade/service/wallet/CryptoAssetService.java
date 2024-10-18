package com.pdp.PixelTrade.service.wallet;

import com.pdp.PixelTrade.dto.ApiResponse;
import com.pdp.PixelTrade.dto.transaction.response.CryptoAssetDTO;
import com.pdp.PixelTrade.entity.wallet.CryptoAsset;
import com.pdp.PixelTrade.entity.wallet.Wallet;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.exceptions.ResourceNotFoundException;
import com.pdp.PixelTrade.exceptions.transaction.WalletNotFoundException;
import com.pdp.PixelTrade.mapper.CryptoAssetMapper;
import com.pdp.PixelTrade.repository.wallet.CryptoAssetRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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
    public CryptoAsset createCryptoAsset(String address, BigDecimal amount, CryptoType type) {
        Wallet wallet = walletService.findByAddress(address);
        if (wallet == null)
            throw new WalletNotFoundException("Wallet not found by address: {0}", address);
        return cryptoAssetRepository.save(CryptoAsset.builder()
                .wallet(wallet)
                .amount(amount)
                .cryptoType(type)
                .build());
    }

    public CryptoAsset update(CryptoAsset asset) {
        return cryptoAssetRepository.save(asset);
    }

    public Optional<CryptoAsset> find(String address, CryptoType cryptoType) {
        return cryptoAssetRepository.find(address, cryptoType);
    }

    public ApiResponse<List<CryptoAssetDTO>> findAllByWalletAddress(@NotNull String address) {
        return ApiResponse.ok(cryptoAssetRepository.findAllByWalletAddress(address).stream()
                .map(cryptoAssetMapper::toCryptoAssetDTO)
                .toList());
    }

    public ApiResponse<List<CryptoAssetDTO>> findLockedAssetsByWalletAddress(@NotNull String address) {
        return ApiResponse.ok(cryptoAssetRepository.findLockedAssetsByWalletAddress(address).stream()
                .map(cryptoAssetMapper::toCryptoAssetDTO)
                .toList());
    }

    public ApiResponse<CryptoAssetDTO> findByWalletAddressAndCryptoType(@NotNull String address, @NotNull CryptoType cryptoType) {
        CryptoAsset cryptoAsset = cryptoAssetRepository.findByWalletAddressAndCryptoType(address, cryptoType).orElseThrow(
                () -> new ResourceNotFoundException("CryptoAsset not found by wallet address {0} and type {1}", address, cryptoType)
        );
        return ApiResponse.ok(cryptoAssetMapper.toCryptoAssetDTO(cryptoAsset));
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
