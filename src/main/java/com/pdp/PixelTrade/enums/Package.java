package com.pdp.PixelTrade.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Aliabbos Ashurov
 * @since 08/October/2024  11:53
 **/
@Getter
@AllArgsConstructor
public enum Package {

    PUBLIC("public/"),
    NFT("nft/"),
    TRANSACTION("transaction/");

    private final String path;
}
