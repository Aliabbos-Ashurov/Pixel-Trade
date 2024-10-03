package com.pdp.PixelTrade.dto.request;

import com.pdp.PixelTrade.dto.DTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 03/October/2024  12:41
 **/
public record RefreshTokenRequestDTO(
        @NotBlank @NotNull String refreshToken
) implements DTO {
}
