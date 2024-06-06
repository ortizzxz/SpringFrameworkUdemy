package com.jesus.springboot.di.app.springboot_di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.jesus.springboot.di.app.springboot_di.repositories.ProductRepository;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Bean
    ProductRepository productRepositoryJSON(){
        return new ProductRepository();
    }
}
