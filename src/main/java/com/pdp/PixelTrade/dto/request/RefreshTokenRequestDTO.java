package com.pdp.PixelTrade.dto.request;

import com.pdp.PixelTrade.dto.DTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

/**
 * @author Aliabbos Ashurov
 * @since 03/October/2024  12:41
 **/
@Validated
public record RefreshTokenRequestDTO(
        @NotBlank @NotNull String refreshToken
) implements DTO {
}
