package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.transaction.response.CryptoAssetResponseDTO;
import com.pdp.PixelTrade.entity.wallet.CryptoAsset;
import com.pdp.PixelTrade.entity.wallet.Wallet;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.exceptions.ResourceNotFoundException;
import com.pdp.PixelTrade.exceptions.transaction.WalletNotFoundException;
import com.pdp.PixelTrade.mapper.CryptoAssetMapper;
import com.pdp.PixelTrade.repository.wallet.CryptoAssetRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.context.annotation.Lazy;
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
public class CryptoAssetService extends AbstractService<CryptoAssetRepository, CryptoAssetMapper> {

    private final WalletService walletService;

    public CryptoAssetService(CryptoAssetRepository repository, CryptoAssetMapper mapper, @Lazy WalletService walletService) {
        super(repository, mapper);
        this.walletService = walletService;
    }

    @Transactional
    public CryptoAsset createCryptoAsset(@NotNull String address,
                                         @NotNull BigDecimal amount,
                                         @NotNull CryptoType type) {
        Wallet wallet = walletService.findByAddress(address);
        if (wallet == null)
            throw new WalletNotFoundException("Wallet not found by address: {0}", address);
        return repository.save(CryptoAsset.builder()
                .wallet(wallet)
                .amount(amount)
                .cryptoType(type)
                .build());
    }

    public CryptoAsset update(@NotNull CryptoAsset asset) {
        return repository.save(asset);
    }

    public Optional<CryptoAsset> find(@NotNull String address, @NotNull CryptoType cryptoType) {
        return repository.find(address, cryptoType);
    }

    public Response<List<CryptoAssetResponseDTO>> findAllByWalletAddressResponse(@NotNull String address) {
        return Response.ok(repository.findAllByWalletAddress(address).stream()
                .map(mapper::toDTO)
                .toList());
    }

    public List<CryptoAssetResponseDTO> findAllByWalletAddress(@NotNull String address) {
        return repository.findAllByWalletAddress(address).stream()
                .map(mapper::toDTO)
                .toList();
    }

    public Response<List<CryptoAssetResponseDTO>> findLockedAssetsByWalletAddress(@NotNull String address) {
        return Response.ok(repository.findLockedAssetsByWalletAddress(address).stream()
                .map(mapper::toDTO)
                .toList());
    }

    public Response<CryptoAssetResponseDTO> findByWalletAddressAndCryptoType(@NotNull String address, @NotNull CryptoType cryptoType) {
        CryptoAsset cryptoAsset = repository.findByWalletAddressAndCryptoType(address, cryptoType).orElseThrow(
                () -> new ResourceNotFoundException("CryptoAsset not found by wallet address {0} and type {1}", address, cryptoType)
        );
        return Response.ok(mapper.toDTO(cryptoAsset));
    }

    public void lockCryptoAsset(@NotNull Long assetId, @NotNull String reason) {
        repository.lockCryptoAsset(reason, assetId);
    }

    public void unlockCryptoAsset(@NotNull Long assetId) {
        repository.unlockCryptoAsset(assetId);
    }

    public boolean isCryptoAssetLocked(@NotNull Long assetId) {
        return repository.isCryptoAssetLocked(assetId);
    }
}
