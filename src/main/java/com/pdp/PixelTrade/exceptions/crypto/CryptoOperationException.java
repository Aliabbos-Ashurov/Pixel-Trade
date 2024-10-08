package com.pdp.PixelTrade.exceptions.crypto;

import com.pdp.PixelTrade.exceptions.BaseException;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:39
 **/
public class CryptoOperationException extends BaseException {

    public CryptoOperationException(String message, Object... args) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "CRYPTO_OPERATION_ERROR", message, args);
    }
}
