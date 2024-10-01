package com.pdp.PixelTrade.handler.exceptions.security;

import java.io.Serial;
import java.text.MessageFormat;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:53
 **/
public class UnauthorizedAccessException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public UnauthorizedAccessException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }
}
