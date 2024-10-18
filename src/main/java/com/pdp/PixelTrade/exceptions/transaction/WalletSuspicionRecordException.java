package com.pdp.PixelTrade.exceptions.transaction;

import com.pdp.PixelTrade.exceptions.BaseException;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 16/October/2024  12:54
 **/
public class WalletSuspicionRecordException extends BaseException {
    public WalletSuspicionRecordException(String message, Object... args) {
        super(HttpStatus.BAD_REQUEST, "BAD_REQUEST", message, args);
    }
}
