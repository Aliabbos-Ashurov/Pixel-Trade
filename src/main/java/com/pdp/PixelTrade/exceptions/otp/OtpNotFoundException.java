package com.pdp.PixelTrade.exceptions.otp;

import com.pdp.PixelTrade.exceptions.BaseException;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 06/October/2024  11:30
 **/
public class OtpNotFoundException extends BaseException {

    public OtpNotFoundException(String message, Object... args) {
        super(HttpStatus.NOT_FOUND, "OTP_NOT_FOUND", message, args);
    }
}
