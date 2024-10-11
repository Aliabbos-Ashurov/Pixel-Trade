package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.request.transaction.TransactionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Aliabbos Ashurov
 * @since 10/October/2024  12:22
 **/
@Service
@RequiredArgsConstructor
public class TransactionService {

    private final CryptoAssetService cryptoAssetService;

    public void transaction(TransactionDTO dto) {
        String fromAddress = dto.fromAddress();

    }
}
