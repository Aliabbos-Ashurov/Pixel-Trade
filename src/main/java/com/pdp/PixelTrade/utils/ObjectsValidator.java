package com.pdp.PixelTrade.utils;

import jakarta.validation.*;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Aliabbos Ashurov
 * @since 05/October/2024  13:56
 **/
@Component
public class ObjectsValidator<T> implements Util {

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    public void validate(T t) {
        Set<ConstraintViolation<T>> violations = validator.validate(t);
        if (!violations.isEmpty()) {
            Set<String> errorMsg = violations
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toSet());
            throw new ValidationException(t.getClass().getSimpleName() + ": " + errorMsg);
        }
    }
}
