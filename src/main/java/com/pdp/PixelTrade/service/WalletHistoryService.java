package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.transaction.response.WalletHistoryDTO;
import com.pdp.PixelTrade.entity.wallet.WalletHistory;
import com.pdp.PixelTrade.repository.WalletHistoryRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 16/October/2024  19:12
 **/
@Service
@RequiredArgsConstructor
public class WalletHistoryService {

    private final WalletHistoryRepository walletHistoryRepository;

    public WalletHistory save(@NotNull WalletHistory walletHistory) {
        return walletHistoryRepository.save(walletHistory);
    }

    public Response<List<WalletHistoryDTO>> findAll() {
        return Response.ok(walletHistoryRepository.findAllDtos());
    }

    public Response<List<WalletHistoryDTO>> findByWalletId(@NotNull Long walletId) {
        return Response.ok(walletHistoryRepository.findByWalletId(walletId));
    }

    public Response<List<WalletHistoryDTO>> findByWalletAddress(@NotNull String address) {
        return Response.ok(walletHistoryRepository.findByWalletAddress(address));
    }
}


