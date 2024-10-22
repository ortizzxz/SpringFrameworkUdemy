package com.jesus.curso.springboot.app.springboot_crud.services;

import java.util.List;

import com.jesus.curso.springboot.app.springboot_crud.entities.User;

public interface UserService {

    List<User> findAll();
    
    User save(User user);

    boolean existsByUsername(String username);

}  