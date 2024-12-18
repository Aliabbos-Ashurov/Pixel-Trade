package com.pdp.PixelTrade.dto.auth;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.pdp.PixelTrade.dto.marker.Response;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

/**
 * @author Aliabbos Ashurov
 * @since 02/October/2024  13:22
 **/
@JsonPropertyOrder({"token", "issuedAt", "expiredAt", "expiresIn"})
public record TokenDTO(
        @NotBlank @NotNull String token,
        @JsonProperty("issued_at")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
        @NotNull LocalDateTime issuedAt,

        @JsonProperty("expired_at")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
        @NotNull LocalDateTime expiredAt,

        @JsonProperty("expires_in")
        @NotNull Long expiresIn
) implements Response {
}
