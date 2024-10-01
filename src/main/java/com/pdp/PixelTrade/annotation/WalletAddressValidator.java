package com.pdp.PixelTrade.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.mapping.Constraint;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  11:47
 **/
public class WalletAddressValidator implements ConstraintValidator<ValidWallet, String> {

    @Override
    public boolean isValid(String walletAddress, ConstraintValidatorContext constraintValidatorContext) {
        return walletAddress != null && walletAddress.matches("^[A-Za-z0-9]{32,70}$");
    }
}
