package com.pdp.PixelTrade.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Aliabbos Ashurov
 * @since 19/October/2024  11:52
 **/
@Getter
@RequiredArgsConstructor
public enum P2PType {
    BUY("BUY"),
    SELL("SELL");
    private final String type;
}
