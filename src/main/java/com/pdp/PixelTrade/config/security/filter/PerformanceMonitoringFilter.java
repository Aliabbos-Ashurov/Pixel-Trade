package com.pdp.PixelTrade.config.security.filter;

import jakarta.annotation.Nonnull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @author Aliabbos Ashurov
 * @since 02/October/2024  12:48
 **/
@Component
public class PerformanceMonitoringFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(PerformanceMonitoringFilter.class);

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    @Override
    protected void doFilterInternal(@Nonnull HttpServletRequest request,
                                    @Nonnull HttpServletResponse response,
                                    @Nonnull FilterChain filterChain) throws ServletException, IOException {
        var startTime = System.currentTimeMillis();
        var requestURI = request.getRequestURI();
        try {
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            logger.error(ANSI_RED + "Error processing request for URI: {}" + ANSI_RESET, requestURI, e);
            throw e;
        } finally {
            var duration = System.currentTimeMillis() - startTime;
            logPerformanceMetrics(request.getMethod(), requestURI, duration, request.getContentType());
        }
    }

    private void logPerformanceMetrics(String method, String requestURI, long duration, String contentType) {
        if (contentType != null && !contentType.isEmpty()) {
            logger.info(ANSI_GREEN + "R-Method: {}, Request URI: {}, Duration: {} ms, Content-Type: {}" + ANSI_RESET,
                    method, requestURI, duration, contentType);
        } else {
            logger.info(ANSI_GREEN + "R-Method: {}, Request URI: {}, Duration: {} ms" + ANSI_RESET,
                    method, requestURI, duration);
        }
    }
}