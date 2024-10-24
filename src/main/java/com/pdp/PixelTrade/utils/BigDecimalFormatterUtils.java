package com.pdp.PixelTrade.utils;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Aliabbos Ashurov
 * @since 18/October/2024  19:24
 **/
@Component
public class BigDecimalFormatterUtils {

    public BigDecimal format(BigDecimal balance) {
        if (balance.compareTo(BigDecimal.ONE) >= 0) {
            return balance.setScale(2, RoundingMode.HALF_UP);
        }
        return balance.stripTrailingZeros();
    }
}
