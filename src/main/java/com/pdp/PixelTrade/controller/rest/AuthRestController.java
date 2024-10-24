package com.pdp.PixelTrade.controller.rest;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.auth.*;
import com.pdp.PixelTrade.service.UserService;
import com.pdp.PixelTrade.service.token.TokenService;
import com.pdp.PixelTrade.utils.Constants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aliabbos Ashurov
 * @since 02/October/2024  13:20
 **/
@RestController
@RequestMapping(Constants.BASE_PATH_V1 + "/auth")
@RequiredArgsConstructor
public class AuthRestController {

    private final TokenService tokenService;
    private final UserService userService;

    @PostMapping(value = "/token",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<TokenResponseDTO>> login(@Valid @RequestBody TokenRequestDTO dto) {
        return ResponseEntity.ok(tokenService.generateToken(dto.username(), dto.password()));
    }

    @PostMapping(value = "/refresh-token",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<TokenResponseDTO>> refreshToken(@Valid @RequestBody RefreshTokenRequestDTO dto) {
        return ResponseEntity.ok(tokenService.refreshToken(dto.refreshToken()));
    }

    @PostMapping(value = "/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Response<UserResponseDTO>> register(@Valid @RequestBody UserCreateDTO dto) {
        return ResponseEntity.ok(userService.create(dto));
    }
}
