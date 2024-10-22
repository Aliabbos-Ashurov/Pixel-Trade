package com.pdp.PixelTrade.exceptions;

import com.pdp.PixelTrade.utils.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 03/September/2024  14:34
 **/
@Getter
public class ResourceNotFoundException extends BaseException {

    public ResourceNotFoundException(String message, Object... args) {
        super(HttpStatus.NOT_FOUND, ErrorCode.RESOURCE_NOT_FOUND, message, args);
    }
}