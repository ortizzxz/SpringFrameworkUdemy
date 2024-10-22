package com.jesus.curso.springboot.jpa.springboot_jpa_relationships.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jesus.curso.springboot.jpa.springboot_jpa_relationships.entities.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Long>{

}
