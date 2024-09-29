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

    USD("US Dollar"),
    EUR("Euro"),
    JPY("Japanese Yen"),
    CNY("Chinese Yuan"),
    UZS("Uzbekistan som");

    private final String name;
}
