package com.pdp.PixelTrade.dto.transaction.request;

import com.pdp.PixelTrade.dto.marker.Request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

/**
 * @author Aliabbos Ashurov
 * @since 14/October/2024  12:28
 **/
public record CryptoCreateDTO(
        @NotBlank @NotNull String name,
        @NotBlank @NotNull String symbol,
        @NotNull MultipartFile image,
        @NotNull BigDecimal feePercentage,
        @NotBlank @NotNull String description
) implements Request {
}
