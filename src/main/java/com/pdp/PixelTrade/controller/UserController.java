package com.pdp.PixelTrade.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aliabbos Ashurov
 * @since 03/October/2024  12:16
 **/
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @GetMapping("/profile/me")
    public String profile() {
        return "me";
    }
}
