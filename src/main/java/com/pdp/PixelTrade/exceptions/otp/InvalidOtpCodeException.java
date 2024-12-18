package com.pdp.PixelTrade.exceptions.otp;

import com.pdp.PixelTrade.exceptions.BaseException;
import com.pdp.PixelTrade.utils.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 06/October/2024  11:32
 **/
public class InvalidOtpCodeException extends BaseException {

    public InvalidOtpCodeException(String message, Object... args) {
        super(HttpStatus.BAD_REQUEST, ErrorCode.INVALID_OTP_CODE, message, args);
    }
}
