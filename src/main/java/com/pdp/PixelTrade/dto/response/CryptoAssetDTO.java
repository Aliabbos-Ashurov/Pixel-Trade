package com.pdp.PixelTrade.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.pdp.PixelTrade.dto.DTO;
import com.pdp.PixelTrade.enums.CryptoType;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 * @author Aliabbos Ashurov
 * @since 05/October/2024  11:14
 **/
@JsonPropertyOrder({"id", "cryptoType", "amount", "isLocked", "lockedReason"})
public record CryptoAssetDTO(
        @NotNull Long id,
        @NotNull BigDecimal amount,

        @JsonProperty("crypto_type")
        @NotNull CryptoType cryptoType,

        @JsonProperty("is_locked")
        Boolean isLocked,

        @JsonProperty("locked_reason")
        String lockedReason
) implements DTO {

    public CryptoAssetDTO of(Long id, CryptoType cryptoType, BigDecimal amount) {
        return new CryptoAssetDTO(id, amount, cryptoType, false, null);
    }
}
