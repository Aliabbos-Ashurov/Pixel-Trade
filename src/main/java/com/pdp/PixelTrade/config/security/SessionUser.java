package com.pdp.PixelTrade.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Aliabbos Ashurov
 * @since 14/September/2024  13:36
 **/
@Component
public class SessionUser {

    public Optional<CustomUserDetails> user() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        if (authentication == null || authentication.getPrincipal() == null)
            return Optional.empty();
        if (authentication.getPrincipal() instanceof CustomUserDetails ud)
            return Optional.of(ud);
        return Optional.empty();
    }

    public Long id() {
        return user().map(CustomUserDetails::id).orElse(-1L);
    }
}