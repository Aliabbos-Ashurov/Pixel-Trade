package com.pdp.PixelTrade.exceptions.payment;

import java.io.Serial;
import java.text.MessageFormat;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:59
 **/
public class PaymentMethodNotSupportedException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public PaymentMethodNotSupportedException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }
}
