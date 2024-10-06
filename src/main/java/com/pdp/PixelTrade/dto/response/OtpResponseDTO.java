package com.pdp.PixelTrade.dto.response;

/**
 * @author Aliabbos Ashurov
 * @since 05/October/2024  15:22
 **/
public record OtpResponseDTO(
        boolean success,
        String message
) implements Response {
}
