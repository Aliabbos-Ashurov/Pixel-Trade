package com.pdp.PixelTrade.service.token;

import com.pdp.PixelTrade.controller.AuthController;
import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.auth.RefreshTokenRequestDTO;
import com.pdp.PixelTrade.dto.auth.TokenDTO;
import com.pdp.PixelTrade.dto.auth.TokenRequestDTO;
import com.pdp.PixelTrade.dto.auth.TokenResponseDTO;
import com.pdp.PixelTrade.entity.User;
import com.pdp.PixelTrade.exceptions.UserNotFoundException;
import com.pdp.PixelTrade.exceptions.security.TokenExpiredException;
import com.pdp.PixelTrade.repository.UserRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author Aliabbos Ashurov
 * @since 02/October/2024  14:03
 **/
@Service
@RequiredArgsConstructor
public class TokenService {

    private final UserRepository userRepository;
    private final JwtTokenService jwtTokenService;
    private final AuthenticationManager authenticationManager;

    public Response<TokenResponseDTO> generateToken(@NotNull String username, @NotNull String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
        User user = userRepository.findByUsername(username);
        TokenDTO accessToken = jwtTokenService.generateAccessToken(user.getId(), user.getUsername(), user.getRole());
        TokenDTO refreshToken = jwtTokenService.generateRefreshToken(user.getUsername());
        return Response.ok(TokenResponseDTO.of(user.getId(), accessToken, refreshToken));
    }

    public Response<TokenResponseDTO> refreshToken(@NotNull String refreshToken) {
        if (!jwtTokenService.validateToken(refreshToken))
            throw new TokenExpiredException("Token has expired or invalid: {0}", refreshToken);
        String username = jwtTokenService.extractUsername(refreshToken);
        User user = userRepository.findByUsername(username);
        if (user == null)
            throw new UserNotFoundException("User not found: {0}", username);
        TokenDTO newAccessToken = jwtTokenService.generateAccessToken(user.getId(), user.getUsername(), user.getRole());
        TokenDTO newRefreshToken = jwtTokenService.generateRefreshToken(user.getUsername());
        return Response.ok(TokenResponseDTO.of(user.getId(), newAccessToken, newRefreshToken));
    }

    private EntityModel<TokenResponseDTO> addLinks(EntityModel<TokenResponseDTO> entityModel,
                                                   String username, String password,
                                                   String refreshToken) {
        entityModel.add(linkTo(methodOn(AuthController.class)
                .login(new TokenRequestDTO(username, password))).withSelfRel());
        entityModel.add(linkTo(methodOn(AuthController.class)
                .refreshToken(new RefreshTokenRequestDTO(refreshToken))).withSelfRel());
        return entityModel;
    }
}
