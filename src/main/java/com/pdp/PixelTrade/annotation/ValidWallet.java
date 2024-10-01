package com.pdp.PixelTrade.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  11:47
 **/
@Constraint(validatedBy = WalletAddressValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidWallet {

    String message() default "Invalid wallet address";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
