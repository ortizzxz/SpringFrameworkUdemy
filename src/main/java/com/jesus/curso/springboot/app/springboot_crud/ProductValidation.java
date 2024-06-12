package com.jesus.curso.springboot.app.springboot_crud;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.jesus.curso.springboot.app.springboot_crud.entities.Product;

@Component
public class ProductValidation implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.name");
        ValidationUtils.rejectIfEmpty(errors, "name", "NotEmpty.description");

        if(product.getPrice() == null){
            errors.rejectValue("price","NotNull.price");
        }
    }

}
