package com.pdp.PixelTrade.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

/**
 * @author Aliabbos Ashurov
 * @since 22/October/2024  13:09
 **/
@Configuration
@EnableJpaAuditing
@RequiredArgsConstructor
public class JpaAuditConfig {

    private final SessionUser sessionUser;

    @Bean
    public AuditorAware<Long> auditorAware() {
        return () -> Optional.of(sessionUser.id());
    }
}

