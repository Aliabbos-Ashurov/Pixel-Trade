package com.pdp.PixelTrade.handler.exceptions.validation;

import java.io.Serial;
import java.text.MessageFormat;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:45
 **/
public class InvalidInputFormatException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public InvalidInputFormatException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }
}
