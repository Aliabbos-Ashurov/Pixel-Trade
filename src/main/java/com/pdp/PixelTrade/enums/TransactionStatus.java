package com.pdp.PixelTrade.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Aliabbos Ashurov
 * @since 02/September/2024  13:18
 **/
@Getter
@AllArgsConstructor
public enum TransactionStatus {

    PENDING("PENDING"),
    COMPLETED("COMPLETED"),
    FAILED("FAILED");

    private final String status;
}