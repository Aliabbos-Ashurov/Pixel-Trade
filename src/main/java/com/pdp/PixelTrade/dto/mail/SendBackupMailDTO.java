package com.pdp.PixelTrade.dto.mail;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 23/October/2024  12:27
 **/
@JsonPropertyOrder({"userId", "mail"})
public record SendBackupMailDTO(

        @JsonProperty("userId")
        @NotNull Long userId,

        @JsonProperty("mail")
        @NotNull String mail
) {
}
