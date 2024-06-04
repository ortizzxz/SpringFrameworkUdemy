package com.curso.jesus.springboot.springboot_web.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.curso.jesus.springboot.springboot_web.models.User;

@Controller
public class UserController {
    //El controlador maneja el Request y devuelve un Response al usuario

    // Un metodo handle maneja una peticion de Request
    @GetMapping("/details")
    public String details(Model model){

        User user = new User("Jesus", "Ortiz");
        model.addAttribute("title", "Bienvenido Usuario");
        model.addAttribute("user", user);
        user.setEmail("jesus@jesus.com");

        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model){
        List<User> users = new ArrayList<>();

        model.addAttribute("users", users);
        model.addAttribute("title", "Listado de usuarios");
        return "list";
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
