package com.pdp.PixelTrade.annotation;

import com.pdp.PixelTrade.enums.ClientToken;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Aliabbos Ashurov
 * @since 08/October/2024  15:24
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BearerAuth {
    ClientToken value();
}
