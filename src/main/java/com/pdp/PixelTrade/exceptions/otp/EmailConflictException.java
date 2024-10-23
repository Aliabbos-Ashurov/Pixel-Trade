package com.pdp.PixelTrade.exceptions.otp;

import com.pdp.PixelTrade.exceptions.BaseException;
import com.pdp.PixelTrade.utils.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 23/October/2024  11:38
 **/
public class EmailConflictException extends BaseException {
    public EmailConflictException(String message, Object... args) {
        super(HttpStatus.CONFLICT, ErrorCode.MAIL_CONFLICT, message, args);
    }
}
