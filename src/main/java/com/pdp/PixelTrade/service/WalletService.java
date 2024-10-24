package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.transaction.response.WalletResponseDTO;
import com.pdp.PixelTrade.entity.wallet.Wallet;
import com.pdp.PixelTrade.exceptions.transaction.WalletNotFoundException;
import com.pdp.PixelTrade.mapper.WalletMapper;
import com.pdp.PixelTrade.repository.WalletRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Response<WalletResponseDTO> findByUserId(Long userId) {
        var wallet = repository.findByUserId(userId)
                .orElse(null);
        assert wallet != null;
        return Response.ok(
                mapper.toDTO(wallet, cryptoAssetService.findAllByWalletAddress(wallet.getAddress()))
        );
    }

    public Wallet findByAddress(@NotNull String address) {
        return repository.findByAddress(address).orElseThrow(
                () -> new WalletNotFoundException("Wallet not found with address: {0}", address)
        );
    }

    public WalletResponseDTO createWallet(@NotNull Wallet wallet) {
        return mapper.toDTO(repository.save(wallet));
    }

    public Response<WalletResponseDTO> findByAddressDto(@NotNull String address) {
        Wallet wallet = repository.findByAddress(address).orElseThrow(
                () -> new WalletNotFoundException("Wallet not found with address: {0}", address)
        );
        return Response.ok(mapper.toDTO(wallet));
    }

    @Transactional
    public Response<WalletResponseDTO> findByWalletId(@NotNull Long id) {
        Wallet wallet = repository.findByWalletId(id).orElseThrow(
                () -> new WalletNotFoundException("Wallet not found with id: {0}", id)
        );
        return Response.ok(mapper.toDTO(wallet));
    }
}
