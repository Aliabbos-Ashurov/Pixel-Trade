package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.response.UserDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;

/**
 * @author Aliabbos Ashurov
 * @since 02/October/2024  09:13
 **/
public interface AuthService {

    Optional<UserDTO> findByUsername(@NotBlank @NotNull String username);
}
