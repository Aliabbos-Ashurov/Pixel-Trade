package com.pdp.PixelTrade.dto.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

/**
 * @author Aliabbos Ashurov
 * @since 08/October/2024  16:42
 **/
public record MessageRequestDTO(
        @JsonProperty("mobile_phone")
        @NotBlank String mobilePhone,
        @NotBlank String message,
        @NotBlank String from,
        @JsonProperty("callback_url")
        String callbackUrl
) {
    public static MessageRequestDTO of(String mobilePhone, String message, String from) {
        return new MessageRequestDTO(mobilePhone, message, from, null);
    }
}
