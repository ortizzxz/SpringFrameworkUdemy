package com.curso.jesus.springboot.springboot_web.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    //El controlador maneja el Request y devuelve un Response al usuario

    // Un metodo handle maneja una peticion de Request
    
    public String details(){

        return "details"; 
    }
}
