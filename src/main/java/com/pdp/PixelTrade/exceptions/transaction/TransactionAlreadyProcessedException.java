package com.pdp.PixelTrade.exceptions.transaction;

import java.io.Serial;
import java.text.MessageFormat;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  13:01
 **/
public class TransactionAlreadyProcessedException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public TransactionAlreadyProcessedException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }
}
