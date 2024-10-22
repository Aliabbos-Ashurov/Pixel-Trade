package com.pdp.PixelTrade.exceptions.security;

import com.pdp.PixelTrade.exceptions.BaseException;
import com.pdp.PixelTrade.utils.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:54
 **/
public class TokenExpiredException extends BaseException {

    public TokenExpiredException(String message, Object... args) {
        super(HttpStatus.UNAUTHORIZED, ErrorCode.TOKEN_EXPIRED, message, args);
    }
}
