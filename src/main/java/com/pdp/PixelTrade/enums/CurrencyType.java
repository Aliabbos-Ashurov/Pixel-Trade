package com.pdp.PixelTrade.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Aliabbos Ashurov
 * @since 28/September/2024  20:04
 **/
@Getter
@RequiredArgsConstructor
public enum CurrencyType {

    USD("USDT"),
    EUR("EUR"),
    JPY("JPY"),
    AUD("AUD"),
    UZS("UZS"),
    RUB("RUB"),
    CHF("CHF");

    private final String name;
}
