package com.jesus.curso.springboot.error.springboot_error.services;

import java.util.List;
import java.util.Optional;

import com.jesus.curso.springboot.error.springboot_error.Models.Domain.User;

public interface UserService {
    Optional<User> findById(Long id);

    
    List<User> findAll();

}
