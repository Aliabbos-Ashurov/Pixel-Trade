package com.pdp.PixelTrade.dto.auth;

import com.pdp.PixelTrade.dto.marker.Request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 21/October/2024  19:22
 **/
public record UserUpdateDTO(
        @NotBlank @NotNull String password
) implements Request {
}
