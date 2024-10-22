package com.jesus.curso.springboot.app.springboot_crud.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequiredValidation implements ConstraintValidator<isRequired, String>{

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        
        return (value != null && !value.isEmpty() && !value.isBlank());
    }

}
