package com.pdp.PixelTrade.dto.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.pdp.PixelTrade.dto.marker.Request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 21/October/2024  19:22
 **/
@JsonPropertyOrder({"oldPassword", "newPassword"})
public record UserUpdateDTO(
        @JsonProperty("old_password")
        @NotBlank @NotNull String oldPassword,
        @JsonProperty("new_password")
        @NotBlank @NotNull String newPassword
) implements Request {
}
