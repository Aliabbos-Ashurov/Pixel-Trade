package com.pdp.PixelTrade.enums;

import lombok.RequiredArgsConstructor;

/**
 * @author Aliabbos Ashurov
 * @since 19/October/2024  12:16
 **/
@RequiredArgsConstructor
public enum P2POrderStatus {
    CANCELLED("CANCELLED"),
    WAITING("WAITING"),
    COMPLETED("COMPLETED");
    private final String value;
}
