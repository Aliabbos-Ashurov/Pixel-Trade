package com.pdp.PixelTrade.dto.request.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pdp.PixelTrade.dto.request.Request;
import com.pdp.PixelTrade.enums.CryptoType;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 * @author Aliabbos Ashurov
 * @since 05/October/2024  13:05
 */
public record CryptoAssetCreationDTO(
        @JsonProperty("wallet_address")
        @NotNull String walletAddress,

        @JsonProperty("crypto_type")
        @NotNull CryptoType cryptoType,

        @NotNull BigDecimal amount
)
        implements Request {
}
