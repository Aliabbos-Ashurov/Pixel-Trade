package com.pdp.PixelTrade.controller;

import com.pdp.PixelTrade.service.wallet.CryptoAssetService;
import com.pdp.PixelTrade.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aliabbos Ashurov
 * @since 16/October/2024  16:10
 **/
@RestController
@RequestMapping(Constants.BASE_PATH_V1 + "/asset")
@RequiredArgsConstructor
public class CryptoAssetController {

    private final CryptoAssetService cryptoAssetService;

}
