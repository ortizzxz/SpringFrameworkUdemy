package com.jesus.curso.springboot.di.factura.springboot_difactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.jesus.curso.springboot.di.factura.springboot_difactura.models.Item;
import com.jesus.curso.springboot.di.factura.springboot_difactura.models.Product;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

    @Bean
    List<Item> itemsInvoiceInformatica(){
        
        Product p1 = new Product("Camara Sony", 500);
        Product p2 = new Product("Lector Codigo Barras", 1750);

        List<Item> items = Arrays.asList(
            new Item(p1, 2),
            new Item(p2, 4)
        );

        return items;
    }
    
    @Bean("default")
    List<Item> itemsInvoiceOficina(){
        
        Product p1 = new Product("Impresora HP", 630);
        Product p2 = new Product("Folio A4 100%", 36);
        Product p3 = new Product("Grapadora Bic", 14);

        List<Item> items = Arrays.asList(
            new Item(p1, 2),
            new Item(p2, 4),
            new Item(p3, 5)
        );

        return items;
    }
}
