package com.pdp.PixelTrade.exceptions.crypto;

import com.pdp.PixelTrade.exceptions.BaseException;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:35
 **/
public class EncryptionException extends BaseException {

    public EncryptionException(String message, Object... args) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "ENCRYPTION_ERROR", message, args);
    }
}
