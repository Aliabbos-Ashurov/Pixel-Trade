package com.pdp.PixelTrade.mapper;

import com.pdp.PixelTrade.config.security.CustomUserDetails;
import com.pdp.PixelTrade.dto.auth.UserCreateDTO;
import com.pdp.PixelTrade.dto.auth.UserDTO;
import com.pdp.PixelTrade.dto.auth.UserResponseDTO;
import com.pdp.PixelTrade.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @author Aliabbos Ashurov
 * @since 02/October/2024  09:21
 **/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserDTO toUserDTO(User user);

    User toUser(UserDTO userDTO);

    User toUser(UserCreateDTO dto);

    UserResponseDTO toUserResponseDTO(User user);

    CustomUserDetails toCustomUserDetails(UserDTO dto);

    CustomUserDetails toCustomUserDetails(User dto);
}
