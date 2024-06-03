package com.curso.jesus.springboot.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController // en vez de solo Controller decimos que es un RestController
@RequestMapping("/api") // esto es la ruta de primer nivel -> es decir todas las rutas por debajo 
                        // de esta deben ser /api/nombreruta
public class UserRestController {
    //El controlador maneja el Request y devuelve un Response al usuario

    // Un metodo handle maneja una peticion de Request
    @GetMapping("/details")

    public Map<String, Object> details(){ // en el Rest no se usa inyeccion 

        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola mundo Spring Boot");
        body.put("name", "Jesus");
        body.put("lastname", "Ortiz");

        return body; 
    } 
     
    /*ESTO ES USANDO MAP
    public String details(Map<String, Object> model){ //Para usar Model lo "inyectamos" en el String con el metodo MODEL

        //un modelAddAttribute es como su nombre indica un declarador de atributo para reutilizar
        model.put("title", "Hola mundo Spring Boot");
        model.put("name", "Jesus");
        model.put("lastname", "Ortiz");
        return "details"; 
    }*/
}
