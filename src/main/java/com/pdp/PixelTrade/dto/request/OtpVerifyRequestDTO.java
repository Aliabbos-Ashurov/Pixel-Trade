package com.pdp.PixelTrade.dto.request;

import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 05/October/2024  15:23
 **/
public record OtpVerifyRequestDTO(
        @NotNull String recipient,
        @NotNull String code
) implements Request {
}
