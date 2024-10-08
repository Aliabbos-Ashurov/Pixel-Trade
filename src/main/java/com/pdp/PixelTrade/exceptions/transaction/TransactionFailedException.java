package com.pdp.PixelTrade.exceptions.transaction;

import com.pdp.PixelTrade.exceptions.BaseException;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:55
 **/
public class TransactionFailedException extends BaseException {

    public TransactionFailedException(String message, Object... args) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "TRANSACTION_FAILED", message, args);
    }
}
