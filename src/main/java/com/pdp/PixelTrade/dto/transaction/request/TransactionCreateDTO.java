package com.pdp.PixelTrade.dto.transaction.request;

import com.pdp.PixelTrade.dto.marker.Request;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.enums.TransactionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 * @author Aliabbos Ashurov
 * @since 10/October/2024  12:15
 **/
public record TransactionCreateDTO(
        @NotBlank @NotNull String fromAddress,
        @NotBlank @NotNull String toAddress,
        @NotNull BigDecimal amount,
        @NotNull CryptoType cryptoType,
        @NotNull TransactionType transactionType
) implements Request {
}
