package com.pdp.PixelTrade.handler.exceptions;

import java.io.Serial;
import java.text.MessageFormat;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:58
 **/
public class UserNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public UserNotFoundException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }
}
