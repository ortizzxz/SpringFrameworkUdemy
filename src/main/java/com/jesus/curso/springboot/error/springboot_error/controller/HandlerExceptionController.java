package com.jesus.curso.springboot.error.springboot_error.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.jesus.curso.springboot.error.springboot_error.Models.Error;

@RestControllerAdvice //-> es como un rest controler pero en vez de estar mapeado a una url va a estar mapeado a un lanzamiento de una exception
public class HandlerExceptionController {

    @ExceptionHandler(ArithmeticException.class) // -> Este es el error al que le vamos a hacer un "catch"
    public ResponseEntity<?> divisionByZero(Exception ex){

        Error error = new Error();
        error.setDate(new Date());
        error.setError("Error Division por Cero");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity.internalServerError().body(error);

        // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }

    @ExceptionHandler({NoHandlerFoundException.class, 
                      NoResourceFoundException.class}) // page not found
    public ResponseEntity<?> pageNotFound(NoHandlerFoundException e){

        Error error = new Error();
        error.setDate(new Date());
        error.setMessage(e.getMessage());
        error.setError("La pagina no existe.");
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(404).body(error);
    }


    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // -> Utilizando anotaciones 
    public Map<String,String> numberFormatExceptionError(Exception ex){

        Map<String,String> error = new HashMap<>();
        error.put("date", new Date().toString());
        error.put("message", ex.getMessage());
        error.put("error", "Numero Incorrecto");
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value() + "");
        
        return error;
    }
}
