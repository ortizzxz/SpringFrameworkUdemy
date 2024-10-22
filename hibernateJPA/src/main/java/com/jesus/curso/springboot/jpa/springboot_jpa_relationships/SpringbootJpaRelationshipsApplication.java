package com.jesus.curso.springboot.jpa.springboot_jpa_relationships;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jesus.curso.springboot.jpa.springboot_jpa_relationships.entities.Address;
import com.jesus.curso.springboot.jpa.springboot_jpa_relationships.entities.Client;
import com.jesus.curso.springboot.jpa.springboot_jpa_relationships.entities.Invoice;
import com.jesus.curso.springboot.jpa.springboot_jpa_relationships.repositories.ClientRepository;
import com.jesus.curso.springboot.jpa.springboot_jpa_relationships.repositories.InvoiceRepository;

import jakarta.transaction.Transactional;


@SpringBootApplication
public class SpringbootJpaRelationshipsApplication implements CommandLineRunner{

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private InvoiceRepository InvoiceRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaRelationshipsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		oneToMany();
	}

	public void manyToOne(){
		
		Client client = new Client("Carlos", "Aranza");
		clientRepository.save(client);

		Invoice invoice = new Invoice("Compras Oficina", 2000L);
		invoice.setClient(client);

		Invoice invoiceDB = InvoiceRepository.save(invoice);

		System.out.println(invoiceDB);
	}
	
	@Transactional
	public void oneToMany(){

		Client client = new Client("Erudito", "Malformado");

		Address ad1 = new Address("Caiman", 45);
		Address ad2 = new Address("PerroFla", 69);

		client.getAddresses().add(ad1);
		client.getAddresses().add(ad2);

		clientRepository.save(client);
	}
	
	
	public void manyToOneFindByIdClient(){
		
		Optional<Client> optionalClient = clientRepository.findById(1L);
		
		if (optionalClient.isPresent()) {
			Client client = optionalClient.orElseThrow();

			Invoice invoice = new Invoice("Compras Oficina", 2000L);
			invoice.setClient(client);

			Invoice invoiceDB = InvoiceRepository.save(invoice);

			System.out.println(invoiceDB);
		}

	}

	@Transactional
	public void deleteAddress(){

		Client client = new Client("Miguelito", "Yankee");

		Address ad1 = new Address("Zulia", 20);
		Address ad2 = new Address("Vargas", 1);

		client.getAddresses().add(ad1);
		client.getAddresses().add(ad2);

		clientRepository.save(client);
		System.out.println(client);
		
		Optional<Client> optClient = clientRepository.findById(3L);

		optClient.ifPresent(c -> {
			c.getAddresses().remove(ad1);
			clientRepository.save(c);
			System.out.println(c);
		});
	}

}
