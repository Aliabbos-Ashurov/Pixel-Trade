package com.pdp.PixelTrade.exceptions.client;

import com.pdp.PixelTrade.exceptions.BaseException;
import com.pdp.PixelTrade.utils.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 08/October/2024  17:41
 **/
public class CurrencyRateFetchException extends BaseException {

    public CurrencyRateFetchException(String message, Object... args) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, ErrorCode.CURRENCY_RATE_FETCH_EXCEPTION, message, args);
    }
}
