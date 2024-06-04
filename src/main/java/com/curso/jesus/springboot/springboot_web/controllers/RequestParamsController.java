package com.curso.jesus.springboot.springboot_web.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.curso.jesus.springboot.springboot_web.models.dto.ParamDto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/params")
public class RequestParamsController {
    
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "N/A") String message){

        ParamDto param = new ParamDto();
        param.setMessage(message);

        return param;
    }
    /*Explicacion de este @RestController -> Basicamente lo que hago es que "foo" tenga un
     * Request param obligatorio que va a ser de tipo String en donde ese "message" va a ser 
     * el que se use para hacer el param.setMessage() -> es decir, el parametro de entrada
     * es el que se le va a pasar al setter de la clase paramdto 
    */
}
