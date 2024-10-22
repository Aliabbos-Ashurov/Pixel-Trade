package com.pdp.PixelTrade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableCaching
@EnableScheduling
@EnableFeignClients
@EnableJpaRepositories
@SpringBootApplication
public class PixelTradeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PixelTradeApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner run() {
//        return args -> {
//        };
//    }
}