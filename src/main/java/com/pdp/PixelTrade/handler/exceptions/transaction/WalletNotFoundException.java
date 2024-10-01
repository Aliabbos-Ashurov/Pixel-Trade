package com.pdp.PixelTrade.handler.exceptions.transaction;

import java.io.Serial;
import java.text.MessageFormat;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:57
 **/
public class WalletNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public WalletNotFoundException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }
}
