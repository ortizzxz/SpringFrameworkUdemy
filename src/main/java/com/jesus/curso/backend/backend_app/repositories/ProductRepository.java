package com.jesus.curso.backend.backend_app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jesus.curso.backend.backend_app.entities.Product;

@RepositoryRestResource(path = "products")
public interface ProductRepository extends CrudRepository<Product, Long> {
    
    
} 