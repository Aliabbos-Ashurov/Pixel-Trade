package com.pdp.PixelTrade.dto.auth;

import com.pdp.PixelTrade.dto.marker.Request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 03/October/2024  12:32
 **/
public record TokenRequestDTO(
        @NotBlank @NotNull String username,
        @NotBlank @NotNull String password
) implements Request {
}
