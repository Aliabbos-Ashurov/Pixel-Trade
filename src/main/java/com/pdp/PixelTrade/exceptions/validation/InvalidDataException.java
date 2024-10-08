package com.pdp.PixelTrade.exceptions.validation;

import com.pdp.PixelTrade.exceptions.BaseException;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  12:46
 **/
public class InvalidDataException extends BaseException {

    public InvalidDataException(String message, Object... args) {
        super(HttpStatus.BAD_REQUEST, "INVALID_DATA", message, args);
    }
}