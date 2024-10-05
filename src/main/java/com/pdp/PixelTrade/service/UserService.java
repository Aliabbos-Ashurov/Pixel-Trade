package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.request.UserRegisterDTO;
import com.pdp.PixelTrade.dto.response.UserResponseDTO;
import com.pdp.PixelTrade.mapper.UserMapper;
import com.pdp.PixelTrade.repository.UserRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Aliabbos Ashurov
 * @since 03/October/2024  15:39
 **/
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponseDTO findById(@NotNull Long id) {
        return userMapper.toUserResponseDTO(userRepository.findByIdAndDeletedFalse(id));
    }

    @Transactional
    public UserResponseDTO register(@NotNull UserRegisterDTO userRegisterDTO) {
        return userMapper.toUserResponseDTO(userRepository.save(userMapper.toUser(userRegisterDTO)));
    }
}
