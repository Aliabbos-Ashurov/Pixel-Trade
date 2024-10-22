package com.pdp.PixelTrade.dto.transaction.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.pdp.PixelTrade.dto.marker.Response;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

/**
 * @author Aliabbos Ashurov
 * @since 22/October/2024  12:16
 **/
@JsonPropertyOrder({"reason", "suspended_at", "reactivated_at", "wallet"})
public record WalletSuspicionRecordResponseDTO(
        @NotBlank @NotNull String reason,

        @JsonProperty("suspended_at")
        @NotNull LocalDateTime suspendedAt,

        @JsonProperty("reactivated_at")
        @NotNull LocalDateTime reactivatedAt,

        @NotNull WalletResponseDTO wallet
) implements Response {
}
