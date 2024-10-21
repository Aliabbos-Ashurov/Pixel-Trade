package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.auth.UserCreateDTO;
import com.pdp.PixelTrade.dto.auth.UserResponseDTO;
import com.pdp.PixelTrade.dto.auth.UserUpdateDTO;
import com.pdp.PixelTrade.entity.User;
import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 21/October/2024  19:11
 **/
public interface UserService extends GenericCrudService<Long, UserResponseDTO, UserCreateDTO, UserUpdateDTO> {

    User findByUsername(@NotNull String username);
}
