package com.pdp.PixelTrade.client;

import com.pdp.PixelTrade.dto.client.CbuUzResponseDTO;
import com.pdp.PixelTrade.enums.CurrencyType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 08/October/2024  17:15
 **/
@FeignClient(name = "CbuUzClient", url = "https://cbu.uz/uz/arkhiv-kursov-valyut/json")
public interface CbuUzClient {

    @GetMapping("/{currencyCode}/")
    List<CbuUzResponseDTO> getCurrency(@PathVariable("currencyCode") CurrencyType type);

    @GetMapping("/{currencyCode}/{date}/")
    List<CbuUzResponseDTO> getCurrencyByDate(@PathVariable("currencyCode") CurrencyType type,
                                             @PathVariable("date") String date);
}
