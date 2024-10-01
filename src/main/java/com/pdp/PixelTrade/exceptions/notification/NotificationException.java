package com.pdp.PixelTrade.exceptions.notification;

import java.io.Serial;
import java.text.MessageFormat;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  13:00
 **/
public class NotificationException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public NotificationException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }
}
