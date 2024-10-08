package com.pdp.PixelTrade.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Aliabbos Ashurov
 * @since 08/October/2024  15:31
 **/
@Getter
@RequiredArgsConstructor
public enum ClientToken {

    ESKIZ("Eskiz"),
    BINANCE("Binance"),
    CBU_UZ("Cbu_uz");
    private final String value;
}
