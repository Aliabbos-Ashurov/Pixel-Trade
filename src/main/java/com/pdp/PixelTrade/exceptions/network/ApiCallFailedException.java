package com.pdp.PixelTrade.exceptions.network;

import com.pdp.PixelTrade.exceptions.BaseException;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:48
 **/
public class ApiCallFailedException extends BaseException {

    public ApiCallFailedException(String message, Object... args) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "API_CALL_FAILED", message, args);
    }
}
