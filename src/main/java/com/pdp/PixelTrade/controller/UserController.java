package com.pdp.PixelTrade.controller;

import com.pdp.PixelTrade.config.security.SessionUser;
import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.auth.UserResponseDTO;
import com.pdp.PixelTrade.service.UserService;
import com.pdp.PixelTrade.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aliabbos Ashurov
 * @since 03/October/2024  12:16
 **/
@RestController
@RequestMapping(Constants.BASE_PATH_V1 + "/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final SessionUser sessionUser;

    @GetMapping(value = "/profile/me", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<UserResponseDTO>> profile() {
        return ResponseEntity.ok(userService.find(sessionUser.id()));
    }
}
