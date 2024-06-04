package com.curso.jesus.springboot.springboot_web.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.curso.jesus.springboot.springboot_web.models.User;
import com.curso.jesus.springboot.springboot_web.models.dto.ParamDto;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message){

        ParamDto param = new ParamDto();
        param.setMessage(message);

        return param;
    }    

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVariable(@PathVariable String product,
                                               @PathVariable Long id){

        Map<String,Object> json = new HashMap<>();
        
        json.put("product", product);                                        
        json.put("id", id);

        return json;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user){
           
        //save user en la bbdd
        
        
        return user;
    }
}

