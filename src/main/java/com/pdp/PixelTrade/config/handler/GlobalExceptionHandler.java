package com.pdp.PixelTrade.config.handler;

import com.pdp.PixelTrade.dto.ErrorResponse;
import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.exceptions.BaseException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Aliabbos Ashurov
 * @since 03/September/2024  14:28
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @Value("${project.log-mode}")
    private boolean LOG_MODE;

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<Response<ErrorResponse>> handleCryptoOperationException(BaseException ex, HttpServletRequest request) {
        logException(ex, request);
        var errorResponse = ErrorResponse.of(ex.getCode(), ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(Response.error(
                ex.getHttpStatus().value(),
                errorResponse
        ), ex.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<ErrorResponse>> handleExceptions(Exception ex, HttpServletRequest request) {
        logException(ex, request);
        var errorResponse = ErrorResponse.of("INTERNAL SERVER ERROR", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(Response.error(
                500,
                errorResponse
        ), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private void logException(Exception ex, HttpServletRequest request) {
        if (LOG_MODE) {
            log.error("Exception occurred at URI: [{}] MESSAGE: {}", request.getRequestURI(), ex.getMessage());
        }
    }
}
