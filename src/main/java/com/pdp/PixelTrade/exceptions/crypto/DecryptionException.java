package com.pdp.PixelTrade.exceptions.crypto;

import java.io.Serial;
import java.text.MessageFormat;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:46
 **/
public class DecryptionException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public DecryptionException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }
}