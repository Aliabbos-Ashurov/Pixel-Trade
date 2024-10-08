package com.pdp.PixelTrade.exceptions.crypto;

import com.pdp.PixelTrade.exceptions.BaseException;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:46
 **/
public class DecryptionException extends BaseException {

    public DecryptionException(String message, Object... args) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "DECRYPTION_ERROR", message, args);
    }
}
