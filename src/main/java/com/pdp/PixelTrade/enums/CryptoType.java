package com.pdp.PixelTrade.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Aliabbos Ashurov
 * @since 02/September/2024  13:04
 **/
@Getter
@RequiredArgsConstructor
public enum CryptoType {

    USDT("USDT"),
    ETH("ETH"),
    BTC("BTC"),
    TON("TON"),
    DOGS("DOGS"),
    SOLANA("SOL"),
    ADA("ADA"),
    BNB("BNB"),
    DOGE("DOGE");

    private final String code;
}
