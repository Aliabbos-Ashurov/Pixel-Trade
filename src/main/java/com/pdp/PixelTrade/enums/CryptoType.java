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

    USDT("USDT", "USD dollar"),
    ETH("ETH", "Ethereum"),
    BTC("BTC", "Bitcoin"),
    TON("TON", "Ton"),
    DOGS("DOGS", "Dogs"),
    SOLANA("SOL", "Solana"),
    ADA("ADA", "Cardano"),
    BNB("BNB", "Binance Coin"),
    DOGE("DOGE", "Dogecoin");

    private final String code;
    private final String value;
}
