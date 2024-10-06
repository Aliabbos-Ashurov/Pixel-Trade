package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.response.UserDTO;
import com.pdp.PixelTrade.mapper.UserMapper;
import com.pdp.PixelTrade.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Aliabbos Ashurov
 * @since 02/October/2024  09:20
 **/
@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;
    private final UserMapper userMapper;

    @Cacheable(value = "users", key = "#username")
    public Optional<UserDTO> findByUsername(String username) {
        return authRepository.findByUsername(username)
                .map(userMapper::toUserDTO);
    }
}
