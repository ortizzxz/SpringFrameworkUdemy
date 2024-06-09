package com.jesus.curso.springboot.jpa.springboot_jpa.repositories;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jesus.curso.springboot.jpa.springboot_jpa.entities.Person;

// no hace falta @anotar
public interface PersonRepository extends CrudRepository<Person, Long>{

    @Query("SELECT P FROM Person P WHERE P.id=?1")
    Optional<Person> findOne(Long id);

    @Query("SELECT P, P.programmingLanguage FROM Person P")
    List<Object[]> findAllMixPersonDataList();

    @Query("SELECT NEW Person(P.name, P.lastname) FROM Person P")
    List<Person> findAllClassPerson();

    @Query("SELECT P FROM Person P WHERE P.name LIKE %?1%")
    Optional<Person> findOneLike(String name);

    List<Person> findByProgrammingLanguage(String programmingLanguage);

    @Query("SELECT P FROM Person P WHERE P.programmingLanguage=?1")
    List<Person> buscarByProgrammingLanguage(String programmingLanguage);

    @Query("SELECT P.name, P.programmingLanguage FROM Person P WHERE P.name=?1")
    List<Object[]> obtenerPersonData(String name);

    @Query("SELECT P.id, P.name, P.lastname, P.programmingLanguage FROM Person P")
    List<Object[]> obtenerPersonDataList();

    @Query("SELECT P.name FROM Person P WHERE P.id=?1")
    String getNameById(Long id);
} 

/*
 * SE PUEDE CONCATENAR DOS COLUMNAS DE UNA TABLA USANDO CONCAT() DE LA SIGUIENTE MANERA 
 *      -> SELECT CONCAT(p.name || ' ' || p.lastname) FROM Person P
 * 
 * Y SE PUEDE USAR UPPER Y LOWER PARA MAYUSCULA Y MINUSCULA 
 *      -> SELECT UPPER (p.name || ' ' || p.lastname) -> CONCATENA S
 * 
 * TAMBIEN SE PUEDE USAR EL BETWEEN
 * Y EL ORDER BY ASC OR DESC
 * Y EL MAX MIN Y COUNT 
 * 
 * Y EL LENGTH DE UN VARCHAR CON -> SELECT LENGTH(P.name)
 * TAMBIEN SE PUEDEN HACER SUBQUERIES -> SELECT - FROM WHERE (SUBCONSULTA)
 * 
 * WHERE IN TAMBIEN SE PUEDE -> WHERE ID IN (1, 2, 3)
 */