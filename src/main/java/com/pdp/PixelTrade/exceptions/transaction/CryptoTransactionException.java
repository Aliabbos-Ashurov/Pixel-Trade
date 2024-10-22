package com.pdp.PixelTrade.exceptions.transaction;

import com.pdp.PixelTrade.exceptions.BaseException;
import com.pdp.PixelTrade.utils.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:57
 **/
public class CryptoTransactionException extends BaseException {

    public CryptoTransactionException(String message, Object... args) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, ErrorCode.CRYPTO_TRANSACTION_ERROR, message, args);
    }
}
