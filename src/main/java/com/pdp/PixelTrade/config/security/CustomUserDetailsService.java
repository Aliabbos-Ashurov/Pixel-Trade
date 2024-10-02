package com.pdp.PixelTrade.config.security;

import com.pdp.PixelTrade.dto.response.UserDTO;
import com.pdp.PixelTrade.mapper.UserMapper;
import com.pdp.PixelTrade.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Aliabbos Ashurov
 * @since 02/October/2024  09:28
 **/
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AuthService authService;
    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO dto = authService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found with: " + username));
        return userMapper.toCustomUserDetails(dto);
    }
}
