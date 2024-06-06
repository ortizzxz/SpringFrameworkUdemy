package com.jesus.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.jesus.springboot.di.app.springboot_di.models.Product;
import com.jesus.springboot.di.app.springboot_di.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository repository;


    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductService() {
        this.repository = new ProductRepository();
    }

    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double precioImpuesto = p.getPrice() * 1.25;
            //instancia
            Product newProduct = (Product) p.clone();
            newProduct.setPrice(precioImpuesto.longValue());
            return newProduct;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id) {
        return repository.findById(id);
    }
}
