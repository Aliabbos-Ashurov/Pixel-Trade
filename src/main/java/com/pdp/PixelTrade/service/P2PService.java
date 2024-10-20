package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.mapper.P2POrderMapper;
import com.pdp.PixelTrade.service.wallet.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Aliabbos Ashurov
 * @since 19/October/2024  16:12
 **/
@Service
@RequiredArgsConstructor
public class P2PService {
    private final TransactionService transactionService;
    private final FeeService feeService;
    private final P2PMarketService p2PMarketService;
    private final CryptoService cryptoService;
    private final CryptoAssetService cryptoAssetService;
    private final WalletService walletService;
    private final WalletHistoryService walletHistoryService;
    private final WalletSuspicionRecordService walletSuspicionRecordService;
    // ------
    private final SellerService sellerService;
    private final P2POrderService p2POrderService;
    private final P2POrderMapper p2POrderMapper;


}
