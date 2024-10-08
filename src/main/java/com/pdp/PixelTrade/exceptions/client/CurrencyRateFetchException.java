package com.pdp.PixelTrade.exceptions.client;

import com.pdp.PixelTrade.exceptions.BaseException;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 08/October/2024  17:41
 **/
public class CurrencyRateFetchException extends BaseException {

    public CurrencyRateFetchException(String message, Object... args) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "CURRENCY_RATE_FETCH", message, args);
    }
}
