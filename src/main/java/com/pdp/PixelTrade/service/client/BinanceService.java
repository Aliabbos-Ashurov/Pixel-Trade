package com.pdp.PixelTrade.service.client;

import com.pdp.PixelTrade.client.BinanceClient;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.enums.CurrencyType;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Aliabbos Ashurov
 * @since 08/October/2024  17:45
 **/
@Service
@RequiredArgsConstructor
public class BinanceService {

    private final BinanceClient binanceClient;
    private final CbuUzService cbuUzService;

    public BigDecimal getAvgPrice(@NotNull CryptoType cryptoType, @NotNull CurrencyType currencyType) {
        if (currencyType.equals(CurrencyType.UZS)) {
            BigDecimal price = binanceClient.getAvgPrice(cryptoType.getCode() + CurrencyType.USD.getName()).price();
            System.out.println(price);
            BigDecimal currency = cbuUzService.getCurrency(CurrencyType.USD);
            System.out.println(currency);

            return price.multiply(currency);
        }
        return binanceClient.getAvgPrice(cryptoType.getCode() + currencyType.getName()).price();
    }
}
