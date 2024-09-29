package com.pdp.PixelTrade.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Aliabbos Ashurov
 * @since 28/September/2024  20:08
 **/
@Getter
@RequiredArgsConstructor
public enum IdentificationLevel {

    BASIC("1000 USD", "15,000 USD", "300 USD", "300 USD", "Not Available"),
    EXTENDED("50,000 USD", "500,000 USD", "5,000 USD", "5,000 USD", "Available"),
    ADVANCED("Unlimited", "Unlimited", "Unlimited", "Unlimited", "Available");

    private final String incomingTransactionDailyLimit;
    private final String incomingTransactionMonthlyLimit;
    private final String cardPurchaseDailyLimit;
    private final String cardPurchaseMonthlyLimit;
    private final String p2pPurchasesAvailability;
}
