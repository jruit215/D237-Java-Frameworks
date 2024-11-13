package com.example.demo.validators;

import com.example.demo.domain.Part;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


@Component
public class PartInventoryValidator implements ConstraintValidator<ValidPartInventory, Part> {

    private ApplicationContext context;
    public static ApplicationContext theContext;
    @Override
    public void initialize(ValidPartInventory constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        if (context == null) return true;
        if (context != null) theContext = context;
        if (part.getInv() >= part.getMin() && part.getInv() <= part.getMax()) {
            return true;
        } else {
            return false;
        }
    }
}
