package com.pdp.PixelTrade.handler.exceptions.crypto;

import java.io.Serial;
import java.text.MessageFormat;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:35
 **/
public class EncryptionException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public EncryptionException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }
}
