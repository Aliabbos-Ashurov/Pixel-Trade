package com.pdp.PixelTrade.dto.transaction.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pdp.PixelTrade.dto.marker.Request;
import com.pdp.PixelTrade.enums.CryptoType;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 * @author Aliabbos Ashurov
 * @since 22/October/2024  11:11
 **/
public record CryptoAssetCreateDTO(
        @JsonProperty("wallet_address")
        @NotNull String walletAddress,

        @JsonProperty("crypto_type")
        @NotNull CryptoType cryptoType,

        @NotNull BigDecimal amount
) implements Request {
}
