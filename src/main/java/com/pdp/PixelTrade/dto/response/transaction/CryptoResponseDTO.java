package com.pdp.PixelTrade.dto.response.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.pdp.PixelTrade.dto.response.Response;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 * @author Aliabbos Ashurov
 * @since 14/October/2024  12:25
 **/
@JsonPropertyOrder({"name", "symbol", "feePercentage", "imageURL"})
public record CryptoResponseDTO(
        @NotBlank @NotNull String name,
        @NotBlank @NotNull String symbol,

        @JsonProperty("fee_percentage")
        @NotNull BigDecimal feePercentage,

        @JsonProperty("image_url")
        @NotBlank @NotNull String imageURL
) implements Response {
}
