package com.pdp.PixelTrade.exceptions.network;

import com.pdp.PixelTrade.exceptions.BaseException;
import com.pdp.PixelTrade.utils.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:49
 **/
public class ConnectionTimeoutException extends BaseException {

    public ConnectionTimeoutException(String message, Object... args) {
        super(HttpStatus.REQUEST_TIMEOUT, ErrorCode.CONNECTION_TIMEOUT, message, args);
    }
}
