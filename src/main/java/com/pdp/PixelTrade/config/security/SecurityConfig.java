package com.pdp.PixelTrade.config.security;

import com.pdp.PixelTrade.config.security.filter.AuthenticationFilter;
import com.pdp.PixelTrade.config.security.filter.PerformanceMonitoringFilter;
import com.pdp.PixelTrade.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * @author Aliabbos Ashurov
 * @since 02/October/2024  12:16
 **/
@Configuration
@RequiredArgsConstructor
@EnableMethodSecurity(
        prePostEnabled = true,
        jsr250Enabled = true,
        securedEnabled = true
)
public class SecurityConfig {

    private final SecurityBeansConfiguration beansConfiguration;
    private final CustomUserDetailsService userDetailsService;
    private final AuthenticationFilter authenticationFilter;
    private final PerformanceMonitoringFilter performanceMonitoringFilter;
    private final CorsProperty corsProperty;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests.requestMatchers(Constants.OPEN_PAGES).permitAll()
                                .anyRequest().authenticated()
                )
                .exceptionHandling(exceptions -> {
                    exceptions.accessDeniedHandler(beansConfiguration.accessDeniedHandler());
                    exceptions.authenticationEntryPoint(beansConfiguration.authenticationEntryPoint());
                })
                .sessionManagement(sessionManagement ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .formLogin(AbstractHttpConfigurer::disable)
                .addFilterBefore(performanceMonitoringFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(corsProperty.getAllowedOrigins());
        configuration.setAllowedHeaders(corsProperty.getAllowedHeaders());
        configuration.setAllowedMethods(corsProperty.getAllowedMethods());
        configuration.setAllowCredentials(corsProperty.isAllowCredentials());
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration(corsProperty.getUrlPattern(), configuration);
        return source;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(beansConfiguration.passwordEncoder());
        authenticationProvider.setUserDetailsService(userDetailsService);
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(authenticationProvider());
    }

}
