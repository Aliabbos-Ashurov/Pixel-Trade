package com.pdp.PixelTrade.exceptions.otp;

import com.pdp.PixelTrade.exceptions.BaseException;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 06/October/2024  11:31
 **/
public class TooManyOtpRequestsException extends BaseException {

    public TooManyOtpRequestsException(String message, Object... args) {
        super(HttpStatus.TOO_MANY_REQUESTS, "TOO_MANY_OTP_REQUESTS", message, args);
    }
}
