package com.pdp.PixelTrade.exceptions.p2p;

import com.pdp.PixelTrade.exceptions.BaseException;
import com.pdp.PixelTrade.utils.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  13:03
 **/
public class P2PMarketNotFoundException extends BaseException {

    public P2PMarketNotFoundException(String message, Object... args) {
        super(HttpStatus.NOT_FOUND, ErrorCode.P2P_MARKET_NOT_FOUND, message, args);
    }
}
