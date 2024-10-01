package com.pdp.PixelTrade.handler.exceptions.security;

import java.io.Serial;
import java.text.MessageFormat;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:54
 **/
public class TokenExpiredException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public TokenExpiredException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }
}
