package com.pdp.PixelTrade.controller.graph;

import com.pdp.PixelTrade.dto.auth.TokenRequestDTO;
import com.pdp.PixelTrade.dto.auth.TokenResponseDTO;
import com.pdp.PixelTrade.service.token.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

/**
 * @author Aliabbos Ashurov
 * @since 12/November/2024  11:29
 **/
@Controller
@RequiredArgsConstructor
public class AuthGraphQLController {

    private final TokenService tokenService;

    @QueryMapping(name = "token")
    public TokenResponseDTO token(@Argument("dto") TokenRequestDTO dto) {
        return tokenService.generateToken(dto.username(), dto.password()).getData();
    }
}
