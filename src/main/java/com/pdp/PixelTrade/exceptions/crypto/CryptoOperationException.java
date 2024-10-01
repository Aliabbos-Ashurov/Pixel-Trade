package com.pdp.PixelTrade.exceptions.crypto;

import java.io.Serial;
import java.text.MessageFormat;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:39
 **/
public class CryptoOperationException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public CryptoOperationException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }
}
