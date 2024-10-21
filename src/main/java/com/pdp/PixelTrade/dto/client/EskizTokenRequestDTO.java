package com.pdp.PixelTrade.dto.client;

import com.pdp.PixelTrade.dto.marker.Request;
import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 08/October/2024  16:39
 **/
public record EskizTokenRequestDTO(
        @NotNull String email,
        @NotNull String password
) implements Request {
}
