package com.pdp.PixelTrade.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 03/October/2024  15:14
 **/
@JsonPropertyOrder({"id", "fullname", "username", "email", "phone", "isPremium", "twoFactorEnabled", "notificationsEnabled"})
public record UserResponseDTO(
        @NotBlank @NotNull Long id,
        @NotBlank @NotNull String fullname,
        @NotBlank @NotNull String username,
        @NotBlank @NotNull String email,
        @NotBlank @NotNull String phone,

        @JsonProperty("is_premium")
        @NotNull boolean premium,

        @JsonProperty("two_factor_enabled")
        @NotNull boolean twoFactorEnabled,
        @JsonProperty("notifications_enabled")
        @NotNull boolean notificationsEnabled
) {
}
