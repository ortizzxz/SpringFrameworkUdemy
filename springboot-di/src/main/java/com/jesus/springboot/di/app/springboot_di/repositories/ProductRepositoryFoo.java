package com.jesus.springboot.di.app.springboot_di.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import com.jesus.springboot.di.app.springboot_di.models.Product;

@Primary
@Repository
public class ProductRepositoryFoo implements IProductRepository{
    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1l, "Asus Monitor", 120L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(id, "Monitor Asus", 120L);
    }

}
