package com.jesus.curso.springboot.app.aop.springboot_aop.controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesus.curso.springboot.app.aop.springboot_aop.services.GreetingService;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greeting;

    @GetMapping("/greeting")
    public ResponseEntity<?> greeting(){

        return ResponseEntity.ok(Collections.singletonMap("greeting", greeting.sayHello("Jesus", "Hola, qué tal"))); 
    }

    @GetMapping("/error")
    public ResponseEntity<?> error(){

        return ResponseEntity.ok(Collections.singletonMap("error", greeting.sayHelloError("Jesus","Simular error")));
    }
}
