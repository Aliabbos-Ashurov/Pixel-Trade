package com.pdp.PixelTrade.dto.transaction.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.pdp.PixelTrade.dto.marker.Response;
import com.pdp.PixelTrade.enums.CryptoType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Aliabbos Ashurov
 * @since 22/October/2024  11:24
 **/
@JsonPropertyOrder({"cryptoType", "amount", "startTime", "endTime", "entryFee", "maxParticipants", "currentParticipants", "description"})
public record MiningEventResponseDTO(
        @NotNull CryptoType cryptoType,
        @NotNull BigDecimal amount,

        @JsonProperty("start_time")
        @NotNull LocalDateTime startTime,

        @JsonProperty("end_time")
        @NotNull LocalDateTime endTime,

        @JsonProperty("entry_fee")
        @NotNull BigDecimal entryFee,

        @JsonProperty("max_participants")
        @NotNull Long maxParticipants,

        @JsonProperty("current_participants")
        @NotNull Long currentParticipants,
        @NotBlank @NotNull String description
) implements Response {
}
