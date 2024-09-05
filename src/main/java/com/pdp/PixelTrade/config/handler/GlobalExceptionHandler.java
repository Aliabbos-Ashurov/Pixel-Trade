package com.pdp.PixelTrade.config.handler;

import com.pdp.PixelTrade.dto.ErrorMessageDTO;
import com.pdp.PixelTrade.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Aliabbos Ashurov
 * @since 03/September/2024  14:28
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @Value("${app.log}")
    private boolean LOG_MODE;

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessageDTO> handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of("RESOURCE_NOT_FOUND", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    private void logException(Exception ex, HttpServletRequest request) {
        if (LOG_MODE) {
            log.error("Exception occurred at URI: [{}] MESSAGE: {}", request.getRequestURI(), ex.getMessage());
        }
    }
}
