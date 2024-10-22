package com.pdp.PixelTrade.dto.transaction.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.pdp.PixelTrade.dto.marker.Response;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.enums.TransactionType;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Aliabbos Ashurov
 * @since 18/October/2024  17:47
 **/
@JsonPropertyOrder({"amount", "cryptoType", "transactionType", "confirmedAt", "description"})
public record WalletHistoryResponseDTO(
        @NotNull BigDecimal amount,

        @JsonProperty("crypto_type")
        @NotNull CryptoType cryptoType,

        @JsonProperty("transaction_type")
        @NotNull TransactionType transactionType,

        @JsonProperty("confirmed_at")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
        @NotNull LocalDateTime confirmedAt,

        String description
) implements Response {
}
