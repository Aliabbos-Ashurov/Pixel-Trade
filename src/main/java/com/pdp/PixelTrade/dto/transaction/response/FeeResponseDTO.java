package com.pdp.PixelTrade.dto.transaction.response;

import com.pdp.PixelTrade.dto.marker.Response;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 * @author Aliabbos Ashurov
 * @since 22/October/2024  11:20
 **/
public record FeeResponseDTO(
        @NotNull BigDecimal fee,
        @NotNull BigDecimal feePercentage
) implements Response {
}
