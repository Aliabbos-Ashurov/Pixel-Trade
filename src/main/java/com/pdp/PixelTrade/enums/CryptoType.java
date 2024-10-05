package com.pdp.PixelTrade.enums;

import com.pdp.PixelTrade.utils.CryptoUtils;
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
    BITCOIN("BTC", "Bitcoin"),
    TON("TON", "Ton"),
    NOT("NOT", "Notcoin"),
    HMSTR("HMSTR", "Hamster"),
    DOGS("DOGS", "Dogs"),
    SOLANA("SOLANA", "Solana"),
    ADA("ADA", "Cardano"),
    BNB("BNB", "Binance Coin"),
    DOGE("DOGE", "Dogecoin");

    private final String code;
    private final String value;
    private String encrypt;

    public String getEncrypt(CryptoUtils cryptoUtils) {
        if (encrypt == null) {
            encrypt = cryptoUtils.encrypt(code);
        }
        return encrypt;
    }
}
