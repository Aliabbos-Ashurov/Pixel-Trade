package com.pdp.PixelTrade.exceptions.network;

import java.io.Serial;
import java.text.MessageFormat;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:48
 **/
public class ApiCallFailedException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ApiCallFailedException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }
}
