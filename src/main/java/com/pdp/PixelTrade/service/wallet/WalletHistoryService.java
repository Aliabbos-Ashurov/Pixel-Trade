package com.pdp.PixelTrade.service.wallet;

import com.pdp.PixelTrade.dto.ApiResponse;
import com.pdp.PixelTrade.dto.transaction.response.WalletHistoryDTO;
import com.pdp.PixelTrade.entity.wallet.WalletHistory;
import com.pdp.PixelTrade.repository.WalletHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
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

    public WalletHistory save(WalletHistory walletHistory) {
        return walletHistoryRepository.save(walletHistory);
    }

    public ApiResponse<List<WalletHistoryDTO>> findAll() {
        return ApiResponse.ok(walletHistoryRepository.findAllDtos());
    }

    public ApiResponse<List<WalletHistoryDTO>> findByWalletId(@Param("walletId") Long walletId) {
        return ApiResponse.ok(walletHistoryRepository.findByWalletId(walletId));
    }

    public ApiResponse<List<WalletHistoryDTO>> findByWalletAddress(@Param("address") String address) {
        return ApiResponse.ok(walletHistoryRepository.findByWalletAddress(address));
    }
}


