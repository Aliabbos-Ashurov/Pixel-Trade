package com.pdp.PixelTrade.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * @author Aliabbos Ashurov
 * @since 05/October/2024  19:23
 **/
@Configuration
public class OtpBeansConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("sandbox.smtp.mailtrap.io");
        javaMailSender.setPort(587);
        javaMailSender.setUsername("6edca5902ec301");
        javaMailSender.setPassword("ed4b404e6c94fc");

        Properties props = javaMailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        return javaMailSender;
    }
}
