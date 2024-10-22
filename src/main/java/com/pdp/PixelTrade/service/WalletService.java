package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.transaction.response.WalletResponseDTO;
import com.pdp.PixelTrade.entity.wallet.Wallet;
import com.pdp.PixelTrade.enums.IdentificationLevel;
import com.pdp.PixelTrade.exceptions.transaction.WalletNotFoundException;
import com.pdp.PixelTrade.mapper.WalletMapper;
import com.pdp.PixelTrade.repository.wallet.WalletRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author Aliabbos Ashurov
 * @since 05/October/2024  11:09
 **/
@Service
public class WalletService extends AbstractService<WalletRepository, WalletMapper> {

    @Lazy
    private final CryptoAssetService cryptoAssetService;

    protected WalletService(WalletRepository repository, WalletMapper mapper, CryptoAssetService cryptoAssetService) {
        super(repository, mapper);
        this.cryptoAssetService = cryptoAssetService;
    }

    public BigDecimal getBalance(@NotNull String address) {
        return repository.getBalance(address);
    }

    public boolean isWalletActive(@NotNull String address) {
        return repository.isWalletActive(address);
    }

    public Wallet findByAddress(@NotNull String address) {
        return repository.findByAddress(address).orElseThrow(
                () -> new WalletNotFoundException("Wallet not found with address: {0}" + address)
        );
    }

    public WalletResponseDTO createWallet(@NotNull Wallet wallet) {
        return mapper.toDTO(repository.save(wallet));
    }

    public Response<WalletResponseDTO> findByAddressDto(@NotNull String address) {
        Wallet wallet = repository.findByAddress(address).orElseThrow(
                () -> new WalletNotFoundException("Wallet not found with address: {0}" + address)
        );
        return Response.ok(mapper.toDTO(wallet));
    }

    @Transactional
    public Response<WalletResponseDTO> findByWalletId(@NotNull Long id) {
        Wallet wallet = repository.findByWalletId(id).orElseThrow(
                () -> new WalletNotFoundException("Wallet not found with id: {0}" + id)
        );
        return Response.ok(mapper.toDTO(wallet));
    }

    public Long countWalletsByIdentificationLevel(@NotNull IdentificationLevel level) {
        return repository.countWalletsByIdentificationLevel(level);
    }

    public void lockAllAssetsInWallet(@NotNull Long walletId, @NotNull String reason) {
        repository.lockAllAssetsInWallet(reason, walletId);
    }

    public void unlockAllAssetsInWallet(@NotNull Long walletId) {
        repository.unlockAllAssetsInWallet(walletId);
    }

    public boolean hasLockedAssets(@NotNull Long walletId) {
        return repository.hasLockedAssets(walletId);
    }
}
