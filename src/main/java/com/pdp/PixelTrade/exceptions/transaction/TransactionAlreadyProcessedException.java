package com.pdp.PixelTrade.exceptions.transaction;

import com.pdp.PixelTrade.exceptions.BaseException;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  13:01
 **/
public class TransactionAlreadyProcessedException extends BaseException {

    public TransactionAlreadyProcessedException(String message, Object... args) {
        super(HttpStatus.CONFLICT, "TRANSACTION_ALREADY_PROCESSED", message, args);
    }
}
