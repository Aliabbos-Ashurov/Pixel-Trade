package com.pdp.PixelTrade.exceptions.payment;

import com.pdp.PixelTrade.exceptions.BaseException;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  13:03
 **/
public class InvalidPaymentDetailsException extends BaseException {

    public InvalidPaymentDetailsException(String message, Object... args) {
        super(HttpStatus.BAD_REQUEST, "INVALID_PAYMENT_DETAILS", message, args);
    }
}
