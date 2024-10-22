package com.pdp.PixelTrade.exceptions.transaction;

import com.pdp.PixelTrade.exceptions.BaseException;
import com.pdp.PixelTrade.utils.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  13:02
 **/
public class TransactionLimitExceededException extends BaseException {

    public TransactionLimitExceededException(String message, Object... args) {
        super(HttpStatus.FORBIDDEN, ErrorCode.TRANSACTION_LIMIT_EXCEEDED, message, args);
    }
}
