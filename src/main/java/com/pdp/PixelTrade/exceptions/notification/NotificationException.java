package com.pdp.PixelTrade.exceptions.notification;

import com.pdp.PixelTrade.exceptions.BaseException;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  13:00
 **/
public class NotificationException extends BaseException {

    public NotificationException(String message, Object... args) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "NOTIFICATION_ERROR", message, args);
    }
}
