package com.pdp.PixelTrade.dto.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.pdp.PixelTrade.dto.marker.Response;
import com.pdp.PixelTrade.enums.TokenType;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

/**
 * @author Aliabbos Ashurov
 * @since 02/October/2024  13:21
 **/
@Validated
@JsonPropertyOrder({"user_id", "token_type", "access", "refresh", "_links"})
public record TokenResponseDTO(
        @JsonProperty("token_type")
        @NotNull TokenType tokenType,
        @JsonProperty("user_id")
        @NotNull Long userId,
        @NotNull TokenDTO access,
        @NotNull TokenDTO refresh
) implements Response {
    public static TokenResponseDTO of(Long userId, TokenDTO access, TokenDTO refresh) {
        return new TokenResponseDTO(TokenType.BEARER, userId, access, refresh);
    }
}
