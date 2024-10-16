package com.pdp.PixelTrade.dto.transaction.response;

import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.enums.TransactionStatus;
import com.pdp.PixelTrade.enums.TransactionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Aliabbos Ashurov
 * @since 14/October/2024  11:52
 **/
public record TransactionResponseDTO(
        @NotNull Long id,
        @NotBlank @NotNull String fromAddress,
        String toAddress,
        @NotNull BigDecimal amount,
        @NotNull CryptoType cryptoType,
        @NotNull TransactionType transactionType,
        @NotNull TransactionStatus transactionStatus,
        @NotNull LocalDateTime confirmedAt,
        String metadata,
        String errorMessage,
        String qrCodeUrl,
        @NotNull BigDecimal feeAmount,
        @NotNull BigDecimal feePercentage
) {

}
