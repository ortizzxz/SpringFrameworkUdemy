package com.jesus.curso.springboot.app.springboot_crud.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = RequiredValidation.class)
@Retention(RetentionPolicy.RUNTIME) // -> se ejecuta en runtime
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface isRequired {

    String message() default "Mensaje de Error personalizado";

     Class<?>[] groups() default {};

     Class<? extends Payload>[] payload() default {};
}
