package com.jesus.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.jesus.springboot.di.app.springboot_di.models.Product;
import com.jesus.springboot.di.app.springboot_di.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ProductService implements IProductService {

    @Autowired
    private Environment environment;

    @Autowired 
    private ProductRepository repository;

    public ProductService(@Qualifier("ProductRepositoryJSON") ProductRepository repository){
        this.repository = repository;
    }
    
    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double precioImpuesto = p.getPrice() * environment.getProperty("config.price.tax", Double.class);
            //instancia
            Product newProduct = (Product) p.clone();
            newProduct.setPrice(precioImpuesto.longValue());
            return newProduct;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }

}
