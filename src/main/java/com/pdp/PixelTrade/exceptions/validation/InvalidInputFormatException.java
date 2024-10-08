package com.pdp.PixelTrade.exceptions.validation;

import com.pdp.PixelTrade.exceptions.BaseException;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:45
 **/
public class InvalidInputFormatException extends BaseException {

    public InvalidInputFormatException(String message, Object... args) {
        super(HttpStatus.BAD_REQUEST, "INVALID_INPUT_FORMAT", message, args);
    }
}
