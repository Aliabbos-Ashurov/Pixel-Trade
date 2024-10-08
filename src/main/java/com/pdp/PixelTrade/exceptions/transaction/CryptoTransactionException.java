package com.pdp.PixelTrade.exceptions.transaction;

import com.pdp.PixelTrade.exceptions.BaseException;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:57
 **/
public class CryptoTransactionException extends BaseException {

    public CryptoTransactionException(String message, Object... args) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "CRYPTO_TRANSACTION_ERROR", message, args);
    }
}
