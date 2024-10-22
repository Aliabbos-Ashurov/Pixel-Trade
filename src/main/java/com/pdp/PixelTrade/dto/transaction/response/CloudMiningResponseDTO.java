package com.pdp.PixelTrade.dto.transaction.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.pdp.PixelTrade.dto.marker.Response;
import com.pdp.PixelTrade.enums.MiningStatus;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Aliabbos Ashurov
 * @since 22/October/2024  11:05
 **/
@JsonPropertyOrder({"startedTime", "miningStatus", "earnedAmount", "miningEvent"})
public record CloudMiningResponseDTO(
        @NotNull LocalDateTime startedTime,
        @NotNull MiningStatus miningStatus,
        @NotNull BigDecimal earnedAmount,

        @JsonProperty("mining_event")
        @NotNull MiningEventResponseDTO miningEvent
) implements Response {
}
