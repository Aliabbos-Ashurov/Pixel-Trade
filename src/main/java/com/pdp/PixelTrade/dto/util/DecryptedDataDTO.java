package com.pdp.PixelTrade.dto.util;

import com.pdp.PixelTrade.dto.DTO;
import com.pdp.PixelTrade.enums.CryptoType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  11:27
 **/
public record DecryptedDataDTO(
        @NotBlank @NotNull String walletId,
        @NotBlank @NotNull CryptoType cryptoType
) implements DTO {
}
