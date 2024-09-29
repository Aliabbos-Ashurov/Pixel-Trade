package com.pdp.PixelTrade.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Aliabbos Ashurov
 * @since 29/September/2024  15:30
 **/
@Getter
@RequiredArgsConstructor
public enum Permission {

    VIEW_WALLET("VIEW_WALLET", "Permission to view wallet details"),
    DEPOSIT("DEPOSIT", "Permission to deposit funds"),
    WITHDRAW("WITHDRAW", "Permission to withdraw funds"),
    TRANSFER("TRANSFER", "Permission to transfer funds"),

    // Crypto Permissions
    VIEW_CRYPTO_PORTFOLIO("VIEW_CRYPTO_PORTFOLIO", "Permission to view cryptocurrency portfolio"),
    BUY_CRYPTO("BUY_CRYPTO", "Permission to buy cryptocurrency"),
    SELL_CRYPTO("SELL_CRYPTO", "Permission to sell cryptocurrency"),
    VIEW_CRYPTO_HISTORY("VIEW_CRYPTO_HISTORY", "Permission to view crypto transaction history"),

    // NFT Permissions
    CREATE_NFT("CREATE_NFT", "Permission to create NFTs"),
    VIEW_NFT("VIEW_NFT", "Permission to view NFT details"),
    TRANSFER_NFT("TRANSFER_NFT", "Permission to transfer NFTs"),
    DELETE_NFT("DELETE_NFT", "Permission to delete NFTs"),

    // Admin Permissions
    MANAGE_USERS("MANAGE_USERS", "Permission to manage users"),
    VIEW_STATISTICS("VIEW_STATISTICS", "Permission to view statistics"),
    MANAGE_PERMISSIONS("MANAGE_PERMISSIONS", "Permission to manage permissions"),
    VIEW_LOGS("VIEW_LOGS", "Permission to view application logs");

    private final String access;
    private final String description;
}

