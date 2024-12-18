package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.transaction.response.CryptoAssetResponseDTO;
import com.pdp.PixelTrade.entity.wallet.CryptoAsset;
import com.pdp.PixelTrade.entity.wallet.Wallet;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.exceptions.ResourceNotFoundException;
import com.pdp.PixelTrade.exceptions.transaction.WalletNotFoundException;
import com.pdp.PixelTrade.mapper.CryptoAssetMapper;
import com.pdp.PixelTrade.repository.CryptoAssetRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Aliabbos Ashurov
 * @since 05/October/2024  12:40
 **/
@Service
public class CryptoAssetService extends AbstractService<CryptoAssetRepository, CryptoAssetMapper> {

    private final WalletService walletService;
    private final CryptoService cryptoService;

    public CryptoAssetService(CryptoAssetRepository repository, CryptoAssetMapper mapper,
                              @Lazy WalletService walletService,
                              CryptoService cryptoService) {
        super(repository, mapper);
        this.walletService = walletService;
        this.cryptoService = cryptoService;
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

    public List<CryptoAsset> findAllByWalletAddressEty(@NotNull String address) {
        return repository.findAllByWalletAddress(address);
    }

    public List<CryptoAssetResponseDTO> findAllByWalletAddress(@NotNull String address) {
        return sendWithPrice(repository.findAllByWalletAddress(address));
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

    private List<CryptoAssetResponseDTO> sendWithPrice(List<CryptoAsset> cryptoAssets) {
        Set<String> symbols = cryptoAssets.stream()
                .map(asset -> asset.getCryptoType().getCode())
                .collect(Collectors.toSet());

        Map<String, BigDecimal> prices = cryptoService.getPrices(symbols);

        return cryptoAssets.stream()
                .map(asset -> {
                    var perPrice = prices.getOrDefault(asset.getCryptoType().getCode(), BigDecimal.ZERO);
                    var balance = perPrice.multiply(asset.getAmount());
                    return mapper.toDTO(asset, balance, perPrice);
                }).toList();
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
