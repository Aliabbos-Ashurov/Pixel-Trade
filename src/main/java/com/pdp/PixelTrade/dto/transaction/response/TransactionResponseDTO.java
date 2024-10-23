package com.pdp.PixelTrade.dto.transaction.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pdp.PixelTrade.dto.marker.Response;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.enums.TransactionStatus;
import com.pdp.PixelTrade.enums.TransactionType;
import jakarta.validation.constraints.DecimalMin;
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
public class TransactionResponseDTO implements Response {

    @NotNull
    private Long id;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime confirmedAt;

    private String metadata;

    private String errorMessage;

    private String qrCodeUrl;

    @NotNull
    private BigDecimal feeAmount;
    @NotNull
    private BigDecimal feePercentage;
}
