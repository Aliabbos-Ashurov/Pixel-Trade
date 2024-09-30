package com.pdp.PixelTrade.util;

import lombok.experimental.UtilityClass;

import java.security.SecureRandom;

/**
 * @author Aliabbos Ashurov
 * @since 30/September/2024  09:32
 **/
@UtilityClass
public class WalletAddressGenerator {

    private static final String ALPHANUMERIC_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int LENGTH = 32;
    private static final SecureRandom random = new SecureRandom();

    public static String generate() {
        char[] result = new char[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            int index = random.nextInt(ALPHANUMERIC_CHARACTERS.length());
            result[i] = ALPHANUMERIC_CHARACTERS.charAt(index);
        }
        return new String(result);
    }
}
