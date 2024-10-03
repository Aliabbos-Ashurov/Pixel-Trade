package com.pdp.PixelTrade.dto.response;

import com.pdp.PixelTrade.dto.DTO;
import com.pdp.PixelTrade.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 02/October/2024  09:14
 **/
public record UserDTO(
        @NotBlank @NotNull Long id,
        @NotBlank @NotNull String fullname,
        @NotBlank @NotNull String username,
        @NotBlank @NotNull String password,
        @NotBlank @NotNull String email,
        @NotBlank @NotNull String phone,
        @NotBlank @NotNull Role role,
        boolean premium
) implements DTO {
    public static UserDTO of(Long id, String fullname, String username, String password, String email, String phone, Role role) {
        return new UserDTO(id, fullname, username, password, email, phone, role, Boolean.FALSE);
    }
}
