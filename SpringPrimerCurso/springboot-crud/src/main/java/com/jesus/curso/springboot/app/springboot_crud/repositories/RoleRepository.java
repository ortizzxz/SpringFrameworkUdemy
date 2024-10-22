package com.jesus.curso.springboot.app.springboot_crud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jesus.curso.springboot.app.springboot_crud.entities.Role;
import java.util.Optional;


public interface RoleRepository extends CrudRepository<Role, Long>{

    Optional<Role> findByName(String name);
} 
