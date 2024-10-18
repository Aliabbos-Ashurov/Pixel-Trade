package com.pdp.PixelTrade.dto.transaction.response;

import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.enums.TransactionStatus;
import com.pdp.PixelTrade.enums.TransactionType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Aliabbos Ashurov
 * @since 14/October/2024  11:52
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponseDTO {

    @NotNull
    private Long id;

    @NotBlank
    @NotNull
    private String fromAddress;
    private String toAddress;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal amount;

    @NotNull
    private CryptoType cryptoType;

    @NotNull
    private TransactionType transactionType;

    @NotNull
    private TransactionStatus transactionStatus;

    @NotNull
    private LocalDateTime confirmedAt;

    private String metadata;

    private String errorMessage;

    private String qrCodeUrl;

    @NotNull
    private BigDecimal feeAmount;
    @NotNull
    private BigDecimal feePercentage;
}
