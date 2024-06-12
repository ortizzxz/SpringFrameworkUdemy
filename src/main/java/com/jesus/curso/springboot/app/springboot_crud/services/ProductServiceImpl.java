package com.jesus.curso.springboot.app.springboot_crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jesus.curso.springboot.app.springboot_crud.entities.Product;
import com.jesus.curso.springboot.app.springboot_crud.repositories.ProductRepository;

//ESTA ES UNA CLASE DE TIPO SERVICE DONDE SE IMPLEMENTAN TODOS LOS SERVICIOS DE LA INTERFAZ
@Service
public class ProductServiceImpl implements ProductService{

    //inyectamos el producto del repositorio
    @Autowired
    private ProductRepository repository;   

    @Override
    @Transactional
    public List<Product> findAll() {

        return (List<Product>) repository.findAll();
    }

    @Transactional(readOnly = true )
    @Override
    public Optional<Product> findById(Long id) {
        
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Product save(Product product) {

        return repository.save(product);
    }

    @Override
    @Transactional
    public Optional<Product> delete(Product product) {

        Optional<Product> productDb = repository.findById(product.getId());

        productDb.ifPresent(prod -> {
            repository.delete(prod);
        });

        return productDb;
        
    }

}
