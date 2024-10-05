package com.pdp.PixelTrade.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 03/October/2024  12:41
 **/
public record RefreshTokenRequestDTO(
        @JsonProperty("refresh_token")
        @NotBlank @NotNull String refreshToken
) implements Request {
}
