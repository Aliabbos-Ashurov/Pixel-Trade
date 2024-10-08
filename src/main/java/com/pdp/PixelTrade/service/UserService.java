package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.request.UserRegisterDTO;
import com.pdp.PixelTrade.dto.response.UserDTO;
import com.pdp.PixelTrade.dto.response.UserResponseDTO;
import com.pdp.PixelTrade.entity.User;
import com.pdp.PixelTrade.mapper.UserMapper;
import com.pdp.PixelTrade.repository.UserRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Aliabbos Ashurov
 * @since 03/October/2024  15:39
 **/
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserResponseDTO findById(@NotNull Long id) {
        return userMapper.toUserResponseDTO(userRepository.findByIdAndDeletedFalse(id));
    }

    public UserDTO findByUsername(@NotNull String username) {
        UserDTO dto = userMapper.toUserDTO(userRepository.findByUsername(username));
        if (dto == null)
            throw new UsernameNotFoundException("Username not found with: " + username);
        return dto;
    }


    public UserResponseDTO register(@NotNull UserRegisterDTO dto) {
        User user = userMapper.toUser(dto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userMapper.toUserResponseDTO(userRepository.save(user));
    }
}
