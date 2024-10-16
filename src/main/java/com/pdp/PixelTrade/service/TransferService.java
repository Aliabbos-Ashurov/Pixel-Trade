package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.ApiResponse;
import com.pdp.PixelTrade.dto.transaction.response.TransactionResponseDTO;
import com.pdp.PixelTrade.service.wallet.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Aliabbos Ashurov
 * @since 14/October/2024  11:48
 **/
@Service
@RequiredArgsConstructor
public class TransferService {
    private final TransactionService transactionService;
    private final FeeService feeService;
    private final P2PMarketService p2PMarketService;
    private final CryptoAssetService cryptoAssetService;
    private final WalletService walletService;
    private final WalletSuspicionRecordService walletSuspicionRecordService;

    public ApiResponse<TransactionResponseDTO> transferW2W() {

    }
}
