package com.curso.jesus.springboot.springboot_web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.jesus.springboot.springboot_web.models.User;
import com.curso.jesus.springboot.springboot_web.models.dto.ParamDto;



@RestController
@RequestMapping("/api/var")
public class PathVariableController {


    @Value("${config.code}")
    private Integer code;

    @Value("${config.username}")
    private String username;

    @Value("${config.message}")
    private String message;

    @Value("${config.listOfValues}")
    private List<String> listOfValues;

    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;

    @Autowired
    private Environment environment;

    @GetMapping("/values")
    public Map<String,Object> values(){

        Map<String,Object> json = new HashMap<>();

        json.put("code", code);
        json.put("username", username);
        json.put("usernameEnv", environment.getProperty("config.username"));
        json.put("message", message);
        json.put("listOfValues", listOfValues);
        json.put("valuesMap", valuesMap);
        
        return json;
    }

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

