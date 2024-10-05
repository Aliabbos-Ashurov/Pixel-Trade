package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.response.WalletDTO;
import com.pdp.PixelTrade.entity.transactions.Wallet;
import com.pdp.PixelTrade.enums.IdentificationLevel;
import com.pdp.PixelTrade.exceptions.transaction.WalletNotFoundException;
import com.pdp.PixelTrade.mapper.WalletMapper;
import com.pdp.PixelTrade.repository.WalletRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Aliabbos Ashurov
 * @since 05/October/2024  11:09
 **/
@Service
@RequiredArgsConstructor
public class WalletService {

    private final WalletRepository walletRepository;
    private final WalletMapper walletMapper;

    public BigDecimal getBalance(@NotNull Long walletId) {
        return walletRepository.getBalance(walletId);
    }

    public Wallet findByAddress(@NotNull String address) {
        return walletRepository.findByAddress(address).orElseThrow(
                () -> new WalletNotFoundException("Wallet not found with address: {0}" + address)
        );
    }

    public WalletDTO findByAddressDto(@NotNull String address) {
        Wallet wallet = walletRepository.findByAddress(address).orElseThrow(
                () -> new WalletNotFoundException("Wallet not found with address: {0}" + address)
        );
        return walletMapper.toWalletDTO(wallet);
    }

    public WalletDTO findByWalletId(@NotNull Long id) {
        Wallet wallet = walletRepository.findByWalletId(id).orElseThrow(
                () -> new WalletNotFoundException("Wallet not found with id: {0}" + id)
        );
        return walletMapper.toWalletDTO(wallet);
    }

    public Long countWalletsByIdentificationLevel(@NotNull IdentificationLevel level) {
        return walletRepository.countWalletsByIdentificationLevel(level);
    }

    public void addBalance(@NotNull Long walletId, @NotNull BigDecimal amount) {
        walletRepository.addBalance(walletId, amount);
    }

    public void subtractBalance(@NotNull Long walletId, @NotNull BigDecimal amount) {
        walletRepository.subtractBalance(walletId, amount);
    }

    public void lockAllAssetsInWallet(@NotNull Long walletId, @NotNull String reason) {
        walletRepository.lockAllAssetsInWallet(walletId, reason);
    }

    public void unlockAllAssetsInWallet(@NotNull Long walletId) {
        walletRepository.unlockAllAssetsInWallet(walletId);
    }

    public boolean hasLockedAssets(@NotNull Long walletId) {
        return walletRepository.hasLockedAssets(walletId);
    }
}
