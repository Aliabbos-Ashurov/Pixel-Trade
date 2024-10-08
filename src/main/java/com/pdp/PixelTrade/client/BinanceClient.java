package com.pdp.PixelTrade.client;

import com.pdp.PixelTrade.dto.client.BinanceResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Aliabbos Ashurov
 * @since 08/October/2024  13:47
 **/
@FeignClient(name = "BinanceClient", url = "https://api.binance.com/api/v3")
public interface BinanceClient {

    @GetMapping("/avgPrice")
    BinanceResponseDTO getAvgPrice(@RequestParam("symbol") String symbol);

}
