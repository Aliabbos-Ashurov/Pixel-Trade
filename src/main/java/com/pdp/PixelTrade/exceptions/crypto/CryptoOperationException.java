package com.pdp.PixelTrade.exceptions.crypto;

import com.pdp.PixelTrade.exceptions.BaseException;
import com.pdp.PixelTrade.utils.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:39
 **/
public class CryptoOperationException extends BaseException {

    public CryptoOperationException(String message, Object... args) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, ErrorCode.CRYPTO_OPERATION_FAILED, message, args);
    }
}
