package com.pdp.PixelTrade.handler.exceptions.transaction;

import java.io.Serial;
import java.text.MessageFormat;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:55
 **/
public class TransactionFailedException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public TransactionFailedException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }
}
