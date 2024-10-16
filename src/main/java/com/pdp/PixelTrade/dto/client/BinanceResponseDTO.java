package com.pdp.PixelTrade.dto.client;

import com.pdp.PixelTrade.dto.Response;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 * @author Aliabbos Ashurov
 * @since 08/October/2024  14:33
 **/
public record BinanceResponseDTO(@NotNull BigDecimal price) implements Response {
}
