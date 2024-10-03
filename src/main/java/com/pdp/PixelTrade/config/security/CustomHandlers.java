package com.pdp.PixelTrade.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pdp.PixelTrade.dto.response.ErrorMessageDTO;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * @author Aliabbos Ashurov
 * @since 02/October/2024  11:54
 **/
@Configuration
@RequiredArgsConstructor
public class CustomHandlers {

    private final ObjectMapper objectMapper;

    private static final int ERROR_CODE_ACCESS_DENIED = 403;
    private static final int ERROR_CODE_UNAUTHORIZED = 401;

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return (request, response, accessDeniedException) -> handleError(response, accessDeniedException, ERROR_CODE_ACCESS_DENIED, request.getRequestURI());
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return (request, response, authException) -> handleError(response, authException, ERROR_CODE_UNAUTHORIZED, request.getRequestURI());
    }

    @SneakyThrows
    private void handleError(HttpServletResponse response, Exception exception, int errorCode, String errorPath) {
        String errorMessage = exception.getMessage();
        ErrorMessageDTO errorMessageDTO = ErrorMessageDTO.of(String.valueOf(errorCode), errorMessage, errorPath);
        response.setStatus(errorCode);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try (ServletOutputStream outputStream = response.getOutputStream()) {
            objectMapper.writeValue(outputStream, errorMessageDTO);
        }
    }
}