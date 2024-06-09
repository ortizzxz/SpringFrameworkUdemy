package com.jesus.curso.springboot.jpa.springboot_jpa.repositories;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jesus.curso.springboot.jpa.springboot_jpa.entities.Person;

// no hace falta @anotar
public interface PersonRepository extends CrudRepository<Person, Long>{

    @Query("SELECT P FROM Person P WHERE P.id=?1")
    Optional<Person> findOne(Long id);

    @Query("SELECT P FROM Person P WHERE P.name LIKE %?1%")
    Optional<Person> findOneLike(String name);

    List<Person> findByProgrammingLanguage(String programmingLanguage);

    @Query("SELECT P FROM Person P WHERE P.programmingLanguage=?1")
    List<Person> buscarByProgrammingLanguage(String programmingLanguage);

    @Query("SELECT P.name, P.programmingLanguage FROM Person P WHERE P.name=?1")
    List<Object[]> obtenerPersonData(String name);
} 

