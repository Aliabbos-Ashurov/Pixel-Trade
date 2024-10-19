package com.pdp.PixelTrade.controller;

import com.pdp.PixelTrade.config.security.SessionUser;
import com.pdp.PixelTrade.dto.ApiResponse;
import com.pdp.PixelTrade.dto.transaction.response.WalletDTO;
import com.pdp.PixelTrade.service.UserService;
import com.pdp.PixelTrade.service.wallet.WalletService;
import com.pdp.PixelTrade.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aliabbos Ashurov
 * @since 03/October/2024  12:00
 **/
@RestController
@RequestMapping(Constants.BASE_PATH_V1 + "/wallet")
@RequiredArgsConstructor
public class WalletController {

    private final UserService userService;
    private final WalletService walletService;
    private final SessionUser sessionUser;


    @GetMapping(value = "/get-me", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<WalletDTO>> getWalletMe() {
        return null;
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<WalletDTO>> getWallet(@PathVariable Long id) {
        return ResponseEntity.ok(walletService.findByWalletId(id));
    }
}
