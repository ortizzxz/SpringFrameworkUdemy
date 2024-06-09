package com.jesus.curso.springboot.jpa.springboot_jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jesus.curso.springboot.jpa.springboot_jpa.entities.Person;
import com.jesus.curso.springboot.jpa.springboot_jpa.repositories.PersonRepository;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		findOneLike();
	}

	public void findOne(){
		// Person person = null;
		// Optional<Person> optionalPerson = repository.findById(1L);

		// if (optionalPerson.isPresent()) {
		// 	person = optionalPerson.get();
		// }

		// System.out.println(person);

		repository.findById(1L).ifPresent(p -> 
		System.out.println(p));
	}

	public void findOneLike(){
		repository.findOneLike("JE").ifPresent(p -> 
		System.out.println(p));
	}

	public void list(){

		
		//List<Person> persons = (List<Person>) repository.findAll();
		List<Person> persons = (List<Person>) repository.buscarByProgrammingLanguage("JAVA");

		persons.stream().forEach(person -> {
			System.out.println(person);
		});
		
		List<Object[]> personValues = repository.obtenerPersonData("Jesus");

		personValues.stream().forEach(p -> {
			System.out.println(p[0] + " es experto en " + p[1]);
		});
	}

}
