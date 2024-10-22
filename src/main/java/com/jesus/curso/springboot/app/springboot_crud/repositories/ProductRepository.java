package com.jesus.curso.springboot.app.springboot_crud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jesus.curso.springboot.app.springboot_crud.entities.Product;


// la interfaz siempre extiende CrudRepository<Clase, ID>
public interface ProductRepository extends CrudRepository<Product, Long>{

    
} 
