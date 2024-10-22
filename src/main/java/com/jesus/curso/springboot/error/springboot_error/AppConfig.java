package com.jesus.curso.springboot.error.springboot_error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jesus.curso.springboot.error.springboot_error.Models.Domain.User;

@Configuration
public class AppConfig {
    //constructor
    
    @Bean
    List<User> users() {
        List<User> users = new ArrayList<>();

        users.add(new User(1L, "Jesus", "Ortiz"));
        users.add(new User(2L, "Maria", "Arantza"));
        users.add(new User(3L, "Ana", "Linares"));
        users.add(new User(4L, "Carla", "Pontevedra"));

        return users;
    }
}
