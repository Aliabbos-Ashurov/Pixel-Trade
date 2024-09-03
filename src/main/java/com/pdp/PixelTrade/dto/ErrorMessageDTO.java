package com.pdp.PixelTrade.dto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author Aliabbos Ashurov
 * @since 03/September/2024  14:30
 **/
public record ErrorMessageDTO(
        String code,
        String message,
        String path,
        String details,
        LocalDateTime timestamp)
        implements DTO {

    public static ErrorMessageDTO of(String code, String message, String path, String details) {
        return new ErrorMessageDTO(code, message, path, details, LocalDateTime.now(ZoneId.of("Asia/Tashkent")));
    }

    public String getTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return timestamp.format(formatter);
    }
}
