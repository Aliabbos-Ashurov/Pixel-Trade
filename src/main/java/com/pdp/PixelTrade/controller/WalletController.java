package com.pdp.PixelTrade.controller;

import com.pdp.PixelTrade.entity.wallet.Wallet;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aliabbos Ashurov
 * @since 03/October/2024  12:00
 **/
@RestController
@RequestMapping("/api/v1/wallet")
@RequiredArgsConstructor
public class WalletController {

    @GetMapping("/get/{id}")
    public Wallet getWallet(@PathVariable Long id) {
        System.out.println(id);
        return new Wallet();
    }
}
