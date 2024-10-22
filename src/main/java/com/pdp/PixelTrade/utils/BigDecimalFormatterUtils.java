package com.pdp.PixelTrade.utils;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author Aliabbos Ashurov
 * @since 18/October/2024  19:24
 **/
@Component
public class BigDecimalFormatterUtils {

    private static final DecimalFormat formatWithDecimals = new DecimalFormat("#.########");
    private static final DecimalFormat formatWithoutDecimals = new DecimalFormat("#");

    public String format(BigDecimal balance) {
        if (balance.scale() > 0 && balance.stripTrailingZeros().scale() <= 8)
            return formatWithDecimals.format(balance);
        else
            return formatWithoutDecimals.format(balance);
    }
}
