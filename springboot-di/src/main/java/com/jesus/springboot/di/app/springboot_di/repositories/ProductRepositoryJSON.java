package com.jesus.springboot.di.app.springboot_di.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jesus.springboot.di.app.springboot_di.models.Product;

public class ProductRepositoryJSON implements IProductRepository{

    private List<Product> list;

    public ProductRepositoryJSON(){
        Resource resource = new ClassPathResource("json/product.json");
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            
            list = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

}
