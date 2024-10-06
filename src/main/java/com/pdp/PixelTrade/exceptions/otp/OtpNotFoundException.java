package com.pdp.PixelTrade.exceptions.otp;

import java.io.Serial;
import java.text.MessageFormat;

/**
 * @author Aliabbos Ashurov
 * @since 06/October/2024  11:30
 **/
public class OtpNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public OtpNotFoundException(String message, Object... params) {
        super(MessageFormat.format(message, params));
    }
}
