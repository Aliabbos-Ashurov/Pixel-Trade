package com.pdp.PixelTrade;

import com.pdp.PixelTrade.config.security.SessionUser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Optional;

@EnableAsync
@EnableJpaAuditing
@EnableCaching
@EnableScheduling
@EnableFeignClients
@EnableJpaRepositories
@SpringBootApplication
public class PixelTradeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PixelTradeApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
        };
    }

    @Bean
    public AuditorAware<Long> auditorAware(SessionUser sessionUser) {
        return () -> Optional.ofNullable(sessionUser.id());
    }
}