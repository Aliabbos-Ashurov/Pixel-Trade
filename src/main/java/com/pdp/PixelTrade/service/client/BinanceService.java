package com.pdp.PixelTrade.service.client;

import com.pdp.PixelTrade.client.BinanceClient;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.enums.CurrencyType;
import com.pdp.PixelTrade.utils.BigDecimalFormatterUtils;
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
    private final BigDecimalFormatterUtils formatterUtils;

    public BigDecimal getAvgPrice(@NotNull CryptoType cryptoType, @NotNull CurrencyType currencyType) {
        return format(
                switch (currencyType) {
                    case UZS -> {
                        BigDecimal usdPrice = binanceClient.getAvgPrice(cryptoType.getCode() + CurrencyType.USD.getName()).price();
                        BigDecimal usdToUzsRate = cbuUzService.getCurrency(CurrencyType.USD);
                        yield usdPrice.multiply(usdToUzsRate);
                    }
                    case USD -> cryptoType.equals(CryptoType.USDT)
                            ? cbuUzService.getCurrency(CurrencyType.USD)
                            : binanceClient.getAvgPrice(cryptoType.getCode() + CurrencyType.USD.getName()).price();
                    default -> binanceClient.getAvgPrice(cryptoType.getCode() + currencyType.getName()).price();
                }
        );
    }

    private BigDecimal format(BigDecimal bigDecimal) {
        return formatterUtils.format(bigDecimal);
    }
}
