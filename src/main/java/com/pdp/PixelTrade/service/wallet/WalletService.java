package com.pdp.PixelTrade.service.wallet;

import com.pdp.PixelTrade.dto.ApiResponse;
import com.pdp.PixelTrade.dto.transaction.response.WalletDTO;
import com.pdp.PixelTrade.entity.wallet.Wallet;
import com.pdp.PixelTrade.enums.IdentificationLevel;
import com.pdp.PixelTrade.exceptions.transaction.WalletNotFoundException;
import com.pdp.PixelTrade.mapper.WalletMapper;
import com.pdp.PixelTrade.repository.wallet.WalletRepository;
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

    public BigDecimal getBalance(@NotNull String address) {
        return walletRepository.getBalance(address);
    }

    public Wallet findByAddress(@NotNull String address) {
        return walletRepository.findByAddress(address).orElseThrow(
                () -> new WalletNotFoundException("Wallet not found with address: {0}" + address)
        );
    }

    public ApiResponse<WalletDTO> findByAddressDto(@NotNull String address) {
        Wallet wallet = walletRepository.findByAddress(address).orElseThrow(
                () -> new WalletNotFoundException("Wallet not found with address: {0}" + address)
        );
        return ApiResponse.ok(walletMapper.toWalletDTO(wallet));
    }

    public ApiResponse<WalletDTO> findByWalletId(@NotNull Long id) {
        Wallet wallet = walletRepository.findByWalletId(id).orElseThrow(
                () -> new WalletNotFoundException("Wallet not found with id: {0}" + id)
        );
        return ApiResponse.ok(walletMapper.toWalletDTO(wallet));
    }

    public Long countWalletsByIdentificationLevel(@NotNull IdentificationLevel level) {
        return walletRepository.countWalletsByIdentificationLevel(level);
    }

    public void lockAllAssetsInWallet(@NotNull Long walletId, @NotNull String reason) {
        walletRepository.lockAllAssetsInWallet(reason, walletId);
    }

    public void unlockAllAssetsInWallet(@NotNull Long walletId) {
        walletRepository.unlockAllAssetsInWallet(walletId);
    }

    public boolean hasLockedAssets(@NotNull Long walletId) {
        return walletRepository.hasLockedAssets(walletId);
    }
}
