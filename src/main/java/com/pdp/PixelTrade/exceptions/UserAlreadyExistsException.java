package com.pdp.PixelTrade.exceptions;

import com.pdp.PixelTrade.utils.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:43
 **/
public class UserAlreadyExistsException extends BaseException {

    public UserAlreadyExistsException(String message, Object... args) {
        super(HttpStatus.CONFLICT, ErrorCode.USER_ALREADY_EXIST, message, args);
    }
}
