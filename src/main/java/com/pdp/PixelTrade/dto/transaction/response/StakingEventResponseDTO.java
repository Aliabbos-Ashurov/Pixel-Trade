package com.pdp.PixelTrade.dto.transaction.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.pdp.PixelTrade.dto.marker.Response;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.enums.StakingEventStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Aliabbos Ashurov
 * @since 22/October/2024  11:41
 **/
@JsonPropertyOrder({"title", "description", "cryptoType", "rewardPercentage",
        "minimumStake", "startDate", "endDate", "eventStatus", "bannerUrl"})
public record StakingEventResponseDTO(
        @NotBlank @NotNull String title,
        @NotBlank @NotNull String description,

        @JsonProperty("crypto_type")
        @NotNull CryptoType cryptoType,

        @JsonProperty("reward_percentage")
        @NotNull BigDecimal rewardPercentage,

        @JsonProperty("minimum_stake")
        @NotNull BigDecimal minimumStake,

        @JsonProperty("start_date")
        @NotNull LocalDateTime startDate,

        @JsonProperty("end_date")
        @NotNull LocalDateTime endDate,

        @JsonProperty("event_status")
        @NotNull StakingEventStatus eventStatus,

        @JsonProperty("banner_url")
        @NotNull String bannerUrl
) implements Response {
}
