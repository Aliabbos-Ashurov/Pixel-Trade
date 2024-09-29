package com.pdp.PixelTrade.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Aliabbos Ashurov
 * @since 02/September/2024  13:04
 **/
@Getter
@RequiredArgsConstructor
public enum CryptoType {

    ETH("Ethereum"),
    BITCOIN("Bitcoin"),
    TON("Ton"),
    NOT("Notcoin"),
    HMSTR("Hamster"),
    DOGS("Dogs"),
    SOLANA("Solana"),
    ADA("Cardano"),
    DOT("Polkadot"),
    BNB("Binance Coin"),
    DOGE("Dogecoin");

    private final String value;
}
