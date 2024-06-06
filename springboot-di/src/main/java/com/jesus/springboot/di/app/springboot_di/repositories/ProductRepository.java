package com.jesus.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import com.jesus.springboot.di.app.springboot_di.models.Product;

import org.springframework.stereotype.Repository;

@Repository
// @RequestScope -> El ciclo de vida de este repositorio solo existe durante una peticion -> 
            //  luego se repite el cliclo crear / instanciar / destruir. Es decir, cuando refrescamos el navegador o hacemos una nueva peticion
// @SessionScope -> El ciclo de vida de este repositorio existe hasta que se acabe la sesion (hasta que se cierre la pestaña)
public class ProductRepository implements IProductRepository {

    private List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
            new Product(1L, "Memoria Corsair 32", 300L),
            new Product(2L, "CPU Intel Core I9", 550L),
            new Product(3L, "Ryzen A600", 650L),
            new Product(4L, "Mouse NVIDIA", 40L)
        );
    }

    public List<Product> findAll() {
        return data;
    }

    public Product findById(Long id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
