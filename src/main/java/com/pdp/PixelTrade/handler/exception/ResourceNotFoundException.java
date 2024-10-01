package com.pdp.PixelTrade.handler.exception;

import lombok.Getter;

import java.io.Serial;

/**
 * @author Aliabbos Ashurov
 * @since 03/September/2024  14:34
 **/
@Getter
public class ResourceNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
