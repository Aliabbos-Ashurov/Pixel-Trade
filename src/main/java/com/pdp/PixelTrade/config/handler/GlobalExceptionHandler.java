package com.pdp.PixelTrade.config.handler;

import com.pdp.PixelTrade.dto.response.ErrorMessageDTO;
import com.pdp.PixelTrade.exceptions.BaseException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
    public ResponseEntity<ErrorMessageDTO> handleCryptoOperationException(BaseException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of(ex.getCode(), ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, ex.getHttpStatus());
    }

    private void logException(Exception ex, HttpServletRequest request) {
        if (LOG_MODE) {
            log.error("Exception occurred at URI: [{}] MESSAGE: {}", request.getRequestURI(), ex.getMessage());
        }
    }
}
