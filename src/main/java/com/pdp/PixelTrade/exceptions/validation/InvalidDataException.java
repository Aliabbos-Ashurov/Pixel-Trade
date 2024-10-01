package com.pdp.PixelTrade.exceptions.validation;

import java.io.Serial;
import java.text.MessageFormat;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:46
 **/
public class InvalidDataException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public InvalidDataException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }
}
