package com.pdp.PixelTrade.exceptions.network;

import com.pdp.PixelTrade.exceptions.BaseException;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 08/October/2024  15:38
 **/
public class ClientTokenNotFoundException extends BaseException {

    public ClientTokenNotFoundException(String message, Object... args) {
        super(HttpStatus.NOT_FOUND, "CLIENT_TOKEN_NOT_FOUND", message, args);
    }
}
