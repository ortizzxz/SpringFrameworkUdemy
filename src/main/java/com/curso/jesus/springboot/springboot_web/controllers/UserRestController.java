package com.curso.jesus.springboot.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.jesus.springboot.springboot_web.models.User;

import org.springframework.web.bind.annotation.RequestMapping;

/*
    Nuestro api rest puede ser con controller utilizando 
    @Controller

    @ResponseBody

    pero esto se puede minimizar utilizando simplemente RestController 
*/ 
@RestController // en vez de solo Controller decimos que es un RestController
@RequestMapping("/api") // esto es la ruta de primer nivel -> es decir todas las rutas por debajo 
                        // de esta deben ser /api/nombreruta
public class UserRestController {
    //El controlador maneja el Request y devuelve un Response al usuario

    // Un metodo handle maneja una peticion de Request
    @GetMapping("/details")

    public Map<String, Object> details(){ // en el Rest no se usa inyeccion 

        User user = new User("Jesus", "Ortiz");
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola mundo Spring Boot");
        body.put("user", user);

        return body; 
    }
}
