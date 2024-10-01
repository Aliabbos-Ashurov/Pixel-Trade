package com.pdp.PixelTrade.exceptions.transaction;

import java.io.Serial;
import java.text.MessageFormat;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  13:02
 **/
public class TransactionLimitExceededException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public TransactionLimitExceededException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }
}
