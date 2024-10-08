package com.pdp.PixelTrade.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Aliabbos Ashurov
 * @since 08/October/2024  11:53
 **/
@Getter
@RequiredArgsConstructor
public enum AwsPackage {

    PUBLIC("public"),
    NFT("nft"),
    TRANSACTION("transaction");

    private final String directory;
}
