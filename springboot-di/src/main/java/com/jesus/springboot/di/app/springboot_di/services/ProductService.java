package com.jesus.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.jesus.springboot.di.app.springboot_di.models.Product;
import com.jesus.springboot.di.app.springboot_di.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double precioImpuesto = p.getPrice() * 1.25;
            p.setPrice(precioImpuesto.longValue());
            return p;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id) {
        return repository.findById(id);
    }
}
