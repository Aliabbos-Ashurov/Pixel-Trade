package com.pdp.PixelTrade.exceptions.security;

import java.io.Serial;
import java.text.MessageFormat;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:50
 **/
public class SessionExpiredException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public SessionExpiredException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }
}
