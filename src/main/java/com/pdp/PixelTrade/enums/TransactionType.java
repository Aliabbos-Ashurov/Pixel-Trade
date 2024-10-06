package com.pdp.PixelTrade.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Aliabbos Ashurov
 * @since 28/September/2024  20:35
 **/
@Getter
@AllArgsConstructor
public enum TransactionType {

    DEPOSIT("DEPOSIT"),
    WITHDRAWAL("WITHDRAWAL"),
    TRANSFER("TRANSFER"),
    PURCHASE("PURCHASE"),
    SALE("SALE"),
    EXCHANGE("EXCHANGE"),
    REFUND("REFUND"),
    STAKING("STAKING"),
    UN_STAKING("UN_STAKING"),
    P2P_BUY("P2P_BUY"),
    P2P_SELL("P2P_SELL");

    private final String displayName;
}
