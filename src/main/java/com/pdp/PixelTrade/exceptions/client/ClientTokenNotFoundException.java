package com.pdp.PixelTrade.exceptions.client;

import com.pdp.PixelTrade.exceptions.BaseException;
import com.pdp.PixelTrade.utils.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 08/October/2024  15:38
 **/
public class ClientTokenNotFoundException extends BaseException {

    public ClientTokenNotFoundException(String message, Object... args) {
        super(HttpStatus.NOT_FOUND, ErrorCode.CLIENT_TOKEN_NOT_FOUND, message, args);
    }
}
