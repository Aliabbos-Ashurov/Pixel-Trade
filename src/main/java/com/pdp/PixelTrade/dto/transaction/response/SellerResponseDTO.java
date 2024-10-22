package com.pdp.PixelTrade.dto.transaction.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.pdp.PixelTrade.dto.marker.Response;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 * @author Aliabbos Ashurov
 * @since 19/October/2024  13:21
 **/
@JsonPropertyOrder({"name", "tradesCount", "rating", "bio", "profilePictureUrl"})
public record SellerResponseDTO(
        @NotNull String name,

        @JsonProperty("trades_count")
        @NotNull Long tradesCount,

        @NotNull BigDecimal rating,
        @NotNull String bio,

        @JsonProperty("profile_picture_url")
        @NotNull String profilePictureUrl
) implements Response {
}
