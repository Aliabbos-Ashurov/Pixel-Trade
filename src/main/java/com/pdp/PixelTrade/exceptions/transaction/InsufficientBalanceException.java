package com.pdp.PixelTrade.exceptions.transaction;

import com.pdp.PixelTrade.exceptions.BaseException;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:53
 **/
public class InsufficientBalanceException extends BaseException {

    public InsufficientBalanceException(String message, Object... args) {
        super(HttpStatus.BAD_REQUEST, "INSUFFICIENT_BALANCE", message, args);
    }
}
