package com.pdp.PixelTrade.dto.transaction.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.pdp.PixelTrade.dto.marker.Response;
import com.pdp.PixelTrade.enums.CurrencyType;
import com.pdp.PixelTrade.enums.IdentificationLevel;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 05/October/2024  11:10
 **/
@JsonPropertyOrder({"id", "balance", "currencyType", "address", "level", "cryptoAssets"})
public record WalletDTO(
        @NotNull Long id,
        @NotNull BigDecimal balance,

        @JsonProperty("currency_type")
        @NotNull CurrencyType currencyType,
        @NotNull String address,
        @NotNull IdentificationLevel level,

        @JsonProperty("crypto_assets")
        List<CryptoAssetDTO> cryptoAssets
) implements Response {
}
