package com.pdp.PixelTrade.annotation;

import com.pdp.PixelTrade.enums.ClientToken;
import com.pdp.PixelTrade.exceptions.client.ClientTokenNotFoundException;
import feign.RequestTemplate;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.pdp.PixelTrade.enums.ClientToken.BINANCE;
import static com.pdp.PixelTrade.enums.ClientToken.CBU_UZ;

/**
 * @author Aliabbos Ashurov
 * @since 08/October/2024  15:25
 **/
@Aspect
@Component
public class BearerAuthAspect {

    @Value("${eskiz.token}")
    private String eskizToken;

    @SneakyThrows
    @Around("@annotation(bearerAuth)")
    public Object addBearerAuth(ProceedingJoinPoint joinPoint, BearerAuth bearerAuth) {
        RequestTemplate requestTemplate = (RequestTemplate) joinPoint.getArgs()[0];
        var token = getToken(bearerAuth.value());
        requestTemplate.header("Authorization", "Bearer " + token);
        return joinPoint.proceed();
    }

    private String getToken(ClientToken clientToken) {
        return switch (clientToken) {
            case ESKIZ -> eskizToken;
            case BINANCE -> throw new ClientTokenNotFoundException("Client token not found: {0}", BINANCE);
            case CBU_UZ -> throw new ClientTokenNotFoundException("Client token not found: {0}", CBU_UZ);
        };
    }
}
