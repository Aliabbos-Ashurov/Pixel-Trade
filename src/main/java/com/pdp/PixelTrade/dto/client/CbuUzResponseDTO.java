package com.pdp.PixelTrade.dto.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pdp.PixelTrade.dto.marker.Response;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 * @author Aliabbos Ashurov
 * @since 08/October/2024  17:21
 **/
public record CbuUzResponseDTO(
        @JsonProperty("Code")
        @NotNull String code,
        @JsonProperty("Rate")
        @NotNull BigDecimal rate
) implements Response {
}
