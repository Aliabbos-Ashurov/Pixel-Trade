package com.pdp.PixelTrade.handler.exceptions;

import java.io.Serial;
import java.text.MessageFormat;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:43
 **/
public class UserAlreadyExistsException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public UserAlreadyExistsException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }
}
