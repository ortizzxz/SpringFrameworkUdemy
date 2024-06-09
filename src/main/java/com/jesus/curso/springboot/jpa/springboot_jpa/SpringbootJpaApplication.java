package com.jesus.curso.springboot.jpa.springboot_jpa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

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
		update();
	}

	@Transactional(readOnly=true) // -> solo consulta
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

	@Transactional
	public void create(){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Name:");
		String name = sc.next();

		System.out.println("Lastname: ");
		String apellido = sc.next();

		System.out.println("Programming Lang:");
		String pl = sc.next();
		sc.close();
		
		Person person = new Person(null, name, apellido, pl);
		Person personNew = repository.save(person);

		System.out.println(personNew);
		
		repository.findById(personNew.getId()).ifPresent(p -> System.out.println(p) );
	}

	@Transactional
	public void update(){

		Scanner sc = new Scanner(System.in);
		System.out.println("ID: ");
		Long id = sc.nextLong();

		Optional<Person> optionalPerson = repository.findById(id);

		optionalPerson.ifPresent(p -> {
			System.out.println("Ingrese el lenguage de Programación: ");
			System.out.println(p);
			String prog = sc.next();
			p.setProgrammingLanguage(prog);
			Person personDB = repository.save(p);
			System.out.println(personDB);
		});

		sc.close();
	}
	
}
