package com.pdp.PixelTrade.controller;

import com.pdp.PixelTrade.dto.request.RefreshTokenRequestDTO;
import com.pdp.PixelTrade.dto.request.TokenRequestDTO;
import com.pdp.PixelTrade.dto.request.UserRegisterDTO;
import com.pdp.PixelTrade.dto.response.TokenResponseDTO;
import com.pdp.PixelTrade.dto.response.UserResponseDTO;
import com.pdp.PixelTrade.service.UserService;
import com.pdp.PixelTrade.service.token.TokenService;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final TokenService tokenService;
    private final UserService userService;

    @PostMapping("/token")
    public ResponseEntity<TokenResponseDTO> login(@RequestBody TokenRequestDTO dto) {
        return ResponseEntity.ok(tokenService.generateToken(dto.username(), dto.password()));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<TokenResponseDTO> refreshToken(@RequestBody RefreshTokenRequestDTO dto) {
        return ResponseEntity.ok(tokenService.refreshToken(dto.refreshToken()));
    }

    @PostMapping("/register")
    private ResponseEntity<UserResponseDTO> register(@RequestBody UserRegisterDTO userRegisterDTO) {
        return ResponseEntity.ok(userService.register(userRegisterDTO));
    }
}
