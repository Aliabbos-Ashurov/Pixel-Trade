package com.pdp.PixelTrade.config.security;

import com.pdp.PixelTrade.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  16:48
 **/
public record CustomUserDetails(Long id, String username, String password, Role role) implements UserDetails {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
}
