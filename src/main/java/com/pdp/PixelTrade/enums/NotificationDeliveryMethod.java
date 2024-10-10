package com.pdp.PixelTrade.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Aliabbos Ashurov
 * @since 10/October/2024  10:25
 **/
@Getter
@RequiredArgsConstructor
public enum NotificationDeliveryMethod {

    APP("APP"),
    EMAIL("EMAIL"),
    PHONE("PHONE"),
    SMS("SMS"),
    PUSH_NOTIFICATION("PUSH_NOTIFICATION");

    private final String value;
}
