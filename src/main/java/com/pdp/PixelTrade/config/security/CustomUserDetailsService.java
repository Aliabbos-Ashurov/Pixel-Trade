package com.pdp.PixelTrade.config.security;

import com.pdp.PixelTrade.mapper.UserMapper;
import com.pdp.PixelTrade.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * @author Aliabbos Ashurov
 * @since 02/October/2024  09:28
 **/
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userMapper.toCustomUserDetails(userService.findByUsername(username));
    }
}
