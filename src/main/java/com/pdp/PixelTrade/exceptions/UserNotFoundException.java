package com.pdp.PixelTrade.exceptions;

import com.pdp.PixelTrade.utils.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:58
 **/
public class UserNotFoundException extends BaseException {

    public UserNotFoundException(String message, Object... args) {
        super(HttpStatus.NOT_FOUND, ErrorCode.NOT_FOUND, message, args);
    }
}
