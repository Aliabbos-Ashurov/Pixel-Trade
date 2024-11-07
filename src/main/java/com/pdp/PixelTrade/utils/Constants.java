package com.pdp.PixelTrade.utils;

/**
 * @author Aliabbos Ashurov
 * @since 13/October/2024  15:06
 **/
public interface Constants {
    String BASE_PATH_V1 = "/api/v1";
    String AUTH_TYPE = "Bearer ";
    String AUTH_HEADER = "Authorization";
    String[] OPEN_PAGES = {
            "/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html",
            "/api/v1/auth/**", "/api/v1/otp/**", "/api/v1/mail/**",
            "/graphiql/**", "/graphql"
    };
}
