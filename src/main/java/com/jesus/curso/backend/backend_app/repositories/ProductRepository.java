package com.jesus.curso.backend.backend_app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jesus.curso.backend.backend_app.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
    
    
} 