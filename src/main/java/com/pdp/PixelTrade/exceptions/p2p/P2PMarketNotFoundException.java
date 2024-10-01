package com.pdp.PixelTrade.exceptions.p2p;

import java.io.Serial;
import java.text.MessageFormat;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  13:03
 **/
public class P2PMarketNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public P2PMarketNotFoundException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }
}
