package com.pdp.PixelTrade.exceptions.payment;

import com.pdp.PixelTrade.exceptions.BaseException;
import com.pdp.PixelTrade.utils.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:59
 **/
public class PaymentMethodNotSupportedException extends BaseException {

    public PaymentMethodNotSupportedException(String message, Object... args) {
        super(HttpStatus.BAD_REQUEST, ErrorCode.PAYMENT_METHOD_NOT_SUPPORTED, message, args);
    }
}
