package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.auth.UserCreateDTO;
import com.pdp.PixelTrade.dto.auth.UserResponseDTO;
import com.pdp.PixelTrade.dto.auth.UserUpdateDTO;
import com.pdp.PixelTrade.entity.User;
import jakarta.validation.constraints.NotNull;

import java.util.function.Supplier;

/**
 * @author Aliabbos Ashurov
 * @since 21/October/2024  19:11
 **/
public interface UserService
        extends GenericCrudService<Long, User, UserResponseDTO, UserCreateDTO, UserUpdateDTO> {

    User findByUsername(@NotNull String username);

    User findById(@NotNull Long id);

    void updateUser(User user);

    Response<Boolean> existEmail(@NotNull String email);

    Response<UserResponseDTO> findMe();

    void isNotExistMail(@NotNull String email, Supplier<RuntimeException> supplier);
}
