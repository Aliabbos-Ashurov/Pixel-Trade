package com.pdp.PixelTrade.dto.client;

import com.pdp.PixelTrade.dto.response.Response;
import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 08/October/2024  16:16
 **/
public record EskizTokenResponseDTO(
        @NotNull Data data
) implements Response {
    public record Data(String token) {
    }
}
