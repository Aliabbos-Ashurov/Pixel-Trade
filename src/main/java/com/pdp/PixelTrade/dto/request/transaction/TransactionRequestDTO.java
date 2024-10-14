package com.pdp.PixelTrade.dto.request.transaction;

import com.pdp.PixelTrade.dto.request.Request;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.enums.TransactionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 * @author Aliabbos Ashurov
 * @since 10/October/2024  12:15
 **/
public record TransactionRequestDTO(
        @NotBlank @NotNull String fromAddress,
        @NotBlank @NotNull String toAddress,
        @NotNull BigDecimal amount,
        @NotNull CryptoType cryptoType,
        @NotBlank @NotNull TransactionType transactionType
) implements Request {
}
