package com.pdp.PixelTrade.controller.graph;

import com.pdp.PixelTrade.dto.transaction.response.CryptoAssetResponseDTO;
import com.pdp.PixelTrade.service.CryptoAssetService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 12/November/2024  11:11
 **/
@Controller
@RequiredArgsConstructor
public class CryptoAssetGraphQLController {

    private final CryptoAssetService cryptoAssetService;

    @QueryMapping(value = "getCryptoAsset")
    public List<CryptoAssetResponseDTO> getCryptoAssets(@Argument String address) {
        return cryptoAssetService.findAllByWalletAddress(address);
    }
}
