package com.pdp.PixelTrade.exceptions.security;

import com.pdp.PixelTrade.exceptions.BaseException;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:53
 **/
public class UnauthorizedAccessException extends BaseException {

    public UnauthorizedAccessException(String message, Object... args) {
        super(HttpStatus.UNAUTHORIZED, "UNAUTHORIZED_ACCESS", message, args);
    }
}
