package com.pdp.PixelTrade.scheduler;

import com.pdp.PixelTrade.entity.Crypto;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.enums.CurrencyType;
import com.pdp.PixelTrade.service.CryptoService;
import com.pdp.PixelTrade.service.client.BinanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 24/October/2024  10:20
 **/
@Component
@RequiredArgsConstructor
public class CryptoScheduler {

    private final CryptoService cryptoService;
    private final BinanceService binanceService;

    @Scheduled(cron = "1 * * * * *")
    public void updatePrices() {
        List<Crypto> cryptos = cryptoService.findAll();
        cryptos.forEach(crypto -> {
            try {
                CryptoType cryptoType = CryptoType.valueOf(crypto.getSymbol().toUpperCase());
                BigDecimal newPrice = binanceService.getAvgPrice(cryptoType, CurrencyType.USD);
                crypto.setPrice(newPrice);
            } catch (IllegalArgumentException e) {
                System.err.println("Invalid Crypto Symbol: " + crypto.getSymbol());
            }
        });
        cryptoService.updateAll(cryptos);
    }
}
