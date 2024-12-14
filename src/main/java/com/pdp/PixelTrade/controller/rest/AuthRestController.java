package com.pdp.PixelTrade.controller.rest;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.auth.*;
import com.pdp.PixelTrade.service.UserService;
import com.pdp.PixelTrade.service.token.TokenService;
import com.pdp.PixelTrade.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
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
@RequestMapping(Constants.BASE_PATH_V1 + "/auth")
@RequiredArgsConstructor
public class AuthRestController {

    private final TokenService tokenService;
    private final UserService userService;

    @Operation(method = "POST",
            description = "to get token through username & password",
            responses = @ApiResponse(
                    responseCode = "200/201",
                    description = "success",
                    content = @Content(mediaType = "application/json")))
    @PostMapping(value = "/token")
    public ResponseEntity<Response<TokenResponseDTO>> login(@Valid @RequestBody TokenRequestDTO dto) {
        return ResponseEntity.ok(tokenService.generateToken(dto.username(), dto.password()));
    }

    @Operation(
            method = "POST",
            description = "user can refresh token through refresh tokens",
            responses = @ApiResponse(
                    responseCode = "401",
                    description = "if jwt expired",
                    content = @Content(mediaType = "application/json")))
    @PostMapping(value = "/refresh-token")
    public ResponseEntity<Response<TokenResponseDTO>> refreshToken(@Valid @RequestBody RefreshTokenRequestDTO dto) {
        return ResponseEntity.ok(tokenService.refreshToken(dto.refreshToken()));
    }

    @Operation(
            method = "POST",
            description = "the way of getting first token",
            responses = @ApiResponse(
                    responseCode = "404",
                    description = "if user has not registered from otp yet"
            ))
    @PostMapping(value = "/register")
    private ResponseEntity<Response<UserResponseDTO>> register(@Valid @RequestBody UserCreateDTO dto) {
        return ResponseEntity.ok(userService.create(dto));
    }
}
