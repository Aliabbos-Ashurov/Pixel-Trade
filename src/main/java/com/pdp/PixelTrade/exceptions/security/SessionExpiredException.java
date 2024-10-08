package com.pdp.PixelTrade.exceptions.security;

import com.pdp.PixelTrade.exceptions.BaseException;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:50
 **/
public class SessionExpiredException extends BaseException {

    public SessionExpiredException(String message, Object... args) {
        super(HttpStatus.UNAUTHORIZED, "SESSION_EXPIRED", message, args);
    }
}
