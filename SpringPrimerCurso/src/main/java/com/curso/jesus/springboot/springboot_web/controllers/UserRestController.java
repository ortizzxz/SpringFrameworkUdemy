package com.curso.jesus.springboot.springboot_web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.jesus.springboot.springboot_web.models.User;
import com.curso.jesus.springboot.springboot_web.models.dto.UserDto;

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
    public UserDto details(){ // en el Rest no se usa inyeccion 

        UserDto userDto = new UserDto();
        User user = new User("Jesus", "Ortiz");

        userDto.setUser(user);
        userDto.setTitle("Este es el titulo.");

        return userDto; 
    }

    //Nos vamos a crear una lista para agregar usuarios 
    @GetMapping("/list")
    public List<User> list(){
        User user1 = new User("Juan", "Mendez");
        User user2 = new User("Carlos", "Garrido");
        User user3 = new User("Daniel", "Mendoza");

        //Creamos la arraylist
        List<User> users = new ArrayList<>(); // Para abreviar todo esto se puede usar el metodo
                                            //List<User> users = new Arrays.asList(user1, user2, user3);
        // Agregamos al arraylist
        users.add(user1);
        users.add(user2);
        users.add(user3);
        
        return users;
    }

    /* 
    public Map<String, Object> details(){ // en el Rest no se usa inyeccion 

        User user = new User("Jesus", "Ortiz");
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola mundo Spring Boot");
        body.put("user", user);

        return body; 
    } */
}
