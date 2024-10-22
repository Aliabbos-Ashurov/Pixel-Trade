package com.pdp.PixelTrade.dto.transaction.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pdp.PixelTrade.dto.marker.Response;
import com.pdp.PixelTrade.enums.CardType;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.enums.CurrencyType;
import com.pdp.PixelTrade.enums.P2PType;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 * @author Aliabbos Ashurov
 * @since 22/October/2024  10:36
 **/
public record P2PMarketResponseDTO(
        @NotNull SellerResponseDTO seller,

        @JsonProperty("crypto_type")
        @NotNull CryptoType cryptoType,

        @JsonProperty("per_price")
        @NotNull BigDecimal perPrice,
        @NotNull BigDecimal amount,

        @JsonProperty("currency_type")
        @NotNull CurrencyType currencyType,

        @JsonProperty("card_type")
        @NotNull CardType cardType,

        @JsonProperty("p2p_type")
        @NotNull P2PType p2PType,

        @NotNull String description
) implements Response {
}
