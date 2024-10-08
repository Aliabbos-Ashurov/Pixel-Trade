package com.pdp.PixelTrade.exceptions;

import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:43
 **/
public class UserAlreadyExistsException extends BaseException {

    public UserAlreadyExistsException(String message, Object... args) {
        super(HttpStatus.CONFLICT, "USER_ALREADY_EXISTS", message, args);
    }
}
