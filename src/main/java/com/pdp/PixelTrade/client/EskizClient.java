package com.pdp.PixelTrade.client;

import com.pdp.PixelTrade.dto.client.EskizBalanceDTO;
import com.pdp.PixelTrade.dto.client.EskizTokenRequestDTO;
import com.pdp.PixelTrade.dto.client.EskizTokenResponseDTO;
import com.pdp.PixelTrade.dto.client.MessageRequestDTO;
import jakarta.validation.constraints.NotNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author Aliabbos Ashurov
 * @since 08/October/2024  14:39
 **/
@FeignClient(name = "EskizClient", url = "https://notify.eskiz.uz/api")
public interface EskizClient {


    @PostMapping("/message/sms/send")
    void sendSms(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                 @RequestBody MessageRequestDTO messageRequest);

    @GetMapping("/user/get-limit")
    EskizBalanceDTO getEskizBalance(@RequestHeader(HttpHeaders.AUTHORIZATION) String token);

    @PostMapping("/auth/login")
    EskizTokenResponseDTO getToken(@NotNull EskizTokenRequestDTO tokenRequestDTO);

//    @PatchMapping("/auth/refresh")
//    EskizTokenResponseDTO refreshToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String token);
}
