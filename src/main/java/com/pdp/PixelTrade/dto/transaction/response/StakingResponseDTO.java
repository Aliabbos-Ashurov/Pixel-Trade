package com.pdp.PixelTrade.dto.transaction.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.pdp.PixelTrade.dto.marker.Response;
import com.pdp.PixelTrade.enums.CryptoType;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Aliabbos Ashurov
 * @since 22/October/2024  11:51
 **/
@JsonPropertyOrder({"cryptoType", "amountStaked", "earned", "stakeStart", "stakeEnd", "stakingEvent"})
public record StakingResponseDTO(
        @JsonProperty("crypto_type")
        @NotNull CryptoType cryptoType,

        @JsonProperty("amount_staked")
        @NotNull BigDecimal amountStaked,

        @NotNull BigDecimal earned,

        @JsonProperty("stake_start")
        @NotNull LocalDateTime stakeStart,

        @JsonProperty("stake_end")
        @NotNull LocalDateTime stakeEnd,

        @JsonProperty("staking_event")
        @NotNull StakingEventResponseDTO stakingEvent
) implements Response {
}
