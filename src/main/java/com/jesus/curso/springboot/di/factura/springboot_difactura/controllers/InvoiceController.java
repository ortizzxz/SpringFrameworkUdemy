package com.jesus.curso.springboot.di.factura.springboot_difactura.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesus.curso.springboot.di.factura.springboot_difactura.models.Invoice;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    
    @Autowired
    private Invoice invoice;

    @GetMapping("/show")
    public Invoice show(){
        return invoice;
    }
}

/*
 * Nota:
 * Es muy importante manejar el Scope de la sesion, y si es singleton o no -> 
 *  Esto quiere decir a que si la sesion es por ejemplo un carro de compra es 1 producto menos que hay en stock y afecta a todos los usuarios
 * Cada usuario tiene su propio carro de compra y no tiene que haber problemas entre carro de compras
 */