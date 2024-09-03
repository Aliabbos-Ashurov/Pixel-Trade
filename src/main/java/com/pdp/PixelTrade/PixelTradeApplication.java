package com.pdp.PixelTrade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PixelTradeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PixelTradeApplication.class, args);
	}

}
