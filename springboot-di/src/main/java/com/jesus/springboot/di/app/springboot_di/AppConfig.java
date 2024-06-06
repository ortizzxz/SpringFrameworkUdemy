package com.jesus.springboot.di.app.springboot_di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.jesus.springboot.di.app.springboot_di.repositories.ProductRepository;
import com.jesus.springboot.di.app.springboot_di.repositories.ProductRepositoryJSON;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Bean
    ProductRepository productRepositoryJSON(){
        return new ProductRepositoryJSON();
    }
}
