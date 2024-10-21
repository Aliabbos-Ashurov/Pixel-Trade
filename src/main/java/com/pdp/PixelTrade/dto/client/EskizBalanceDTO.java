package com.pdp.PixelTrade.dto.client;

import com.pdp.PixelTrade.dto.marker.Response;

/**
 * @author Aliabbos Ashurov
 * @since 08/October/2024  14:59
 **/
public record EskizBalanceDTO(Data data) implements Response {
    public record Data(int balance) {
    }
}
