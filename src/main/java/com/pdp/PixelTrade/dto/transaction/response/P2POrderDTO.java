package com.pdp.PixelTrade.dto.transaction.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.enums.CardType;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.enums.P2POrderStatus;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 * @author Aliabbos Ashurov
 * @since 19/October/2024  16:22
 **/
@JsonPropertyOrder({"amount", "perPrice", "cryptoType", "cardType", "orderStatus", "seller"})
public record P2POrderDTO(
        @NotNull BigDecimal amount,

        @JsonProperty("per_price")
        @NotNull BigDecimal perPrice,

        @JsonProperty("crypto_type")
        @NotNull CryptoType cryptoType,

        @JsonProperty("card_type")
        @NotNull CardType cardType,

        @JsonProperty("order_status")
        @NotNull P2POrderStatus orderStatus,

        @JsonProperty("seller")
        @NotNull SellerResponseDTO seller

) implements Response {
}
