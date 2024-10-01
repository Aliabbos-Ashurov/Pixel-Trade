package com.pdp.PixelTrade.handler.exceptions.payment;

import java.io.Serial;
import java.text.MessageFormat;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  13:03
 **/
public class InvalidPaymentDetailsException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public InvalidPaymentDetailsException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }
}
