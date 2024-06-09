package com.jesus.curso.springboot.jpa.springboot_jpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jesus.curso.springboot.jpa.springboot_jpa.entities.Person;

// no hace falta @anotar
public interface PersonRepository extends CrudRepository<Person, Long>{
    
} 