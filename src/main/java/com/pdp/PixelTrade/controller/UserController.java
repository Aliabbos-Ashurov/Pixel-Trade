package com.pdp.PixelTrade.controller;

import com.pdp.PixelTrade.config.security.SessionUser;
import com.pdp.PixelTrade.dto.response.UserResponseDTO;
import com.pdp.PixelTrade.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aliabbos Ashurov
 * @since 03/October/2024  12:16
 **/
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final SessionUser sessionUser;

    @GetMapping("/profile/me")
    public ResponseEntity<UserResponseDTO> profile() {
        return ResponseEntity.ok(userService.findById(sessionUser.id()));
    }
}
