package com.pdp.PixelTrade.handler.exceptions.network;

import java.io.Serial;
import java.text.MessageFormat;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:49
 **/
public class ConnectionTimeoutException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ConnectionTimeoutException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }
}
