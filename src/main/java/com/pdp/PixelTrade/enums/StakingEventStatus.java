package com.pdp.PixelTrade.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Aliabbos Ashurov
 * @since 10/October/2024  11:02
 **/
@Getter
@RequiredArgsConstructor
public enum StakingEventStatus {

    WAITING("WAITING"),
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE"),
    COMPLETED("COMPLETED"),
    CANCELED("CANCELED");

    private final String value;
}
