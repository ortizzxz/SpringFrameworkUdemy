package com.jesus.curso.springboot.error.springboot_error.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesus.curso.springboot.error.springboot_error.Models.Domain.User;
import com.jesus.curso.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.jesus.curso.springboot.error.springboot_error.services.UserService;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserService service;

    @GetMapping
    public String index(){

        // vamos a simular un error 
        // int value = 100 / 0;
        
        // int value = Integer.parseInt("10");
        // System.out.println(value);

        return "OK 200";
    }

    @GetMapping("/show/{id}")
    public User show(@PathVariable(name = "id") Long id){
        User user = service.findById(id).orElseThrow(() 
        -> new UserNotFoundException("Usuario no hallado")); // -> aqui directamente coge el metodo del autowired de userserviceimpl
       
        /* 
        Optional<User> optionalUser = service.findById(id);
        
        if(optionalUser.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(optionalUser.orElseThrow()); 
        */

        return user;
    }

    @GetMapping("/showall")
    public List<User> showAll(){
        return service.findAll();
    }
}
