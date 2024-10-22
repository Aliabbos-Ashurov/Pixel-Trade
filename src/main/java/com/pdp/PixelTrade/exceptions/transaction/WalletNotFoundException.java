package com.pdp.PixelTrade.exceptions.transaction;

import com.pdp.PixelTrade.exceptions.BaseException;
import com.pdp.PixelTrade.utils.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:57
 **/
public class WalletNotFoundException extends BaseException {

    public WalletNotFoundException(String message, Object... args) {
        super(HttpStatus.NOT_FOUND, ErrorCode.WALLET_NOT_FOUND, message, args);
    }
}
