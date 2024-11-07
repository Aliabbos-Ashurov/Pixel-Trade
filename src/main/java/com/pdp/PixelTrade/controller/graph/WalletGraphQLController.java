package com.pdp.PixelTrade.controller.graph;

import com.pdp.PixelTrade.dto.transaction.response.WalletResponseDTO;
import com.pdp.PixelTrade.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

/**
 * @author Aliabbos Ashurov
 * @since 02/November/2024  15:33
 **/
@Controller
@RequiredArgsConstructor
public class WalletGraphQLController {
    private final WalletService walletService;


    @QueryMapping(value = "getWalletMe")
    public WalletResponseDTO getWalletMe() {
        return walletService.getMe().getData();
    }
}
