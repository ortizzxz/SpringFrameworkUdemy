package com.jesus.curso.springboot.app.springboot_crud.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import com.jesus.curso.springboot.app.springboot_crud.ProductValidation; 
import com.jesus.curso.springboot.app.springboot_crud.entities.Product;
import com.jesus.curso.springboot.app.springboot_crud.services.ProductService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    // @Autowired
    // private ProductValidation productValidation;

    @GetMapping
    public List<Product> list(){
        return service.findAll();
    }

    @GetMapping("/{id}") // -> ESTO ES UN PATH VARIABLE, ES DECIR QUE CAMBIA Y PARA ANOTAR QUE LO QUE BUSCO /ID ES LO QUE QUIERO INYECTAR EN ID
    public ResponseEntity<?> view(@PathVariable Long id){ // HAGO UN @PATHVARIABLE
        
        Optional<Product> productOptional = service.findById(id);
        
        if(productOptional.isPresent()){
            return ResponseEntity.ok(productOptional.orElseThrow()); // -> si exsite ese producto lo devolvemos ELSE
        }else{
            return ResponseEntity.notFound().build(); // -> ERROR 404
        }

    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Product product, BindingResult result){

        // productValidation.validate(product, result);

        if(result.hasFieldErrors()){
            return validation(result);
        }

        Product productNew = service.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(productNew);
    }    

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Product product, BindingResult result, @PathVariable Long id){

        // productValidation.validate(product, result);

        if(result.hasFieldErrors()){
            return validation(result);
        }

        Optional<Product> productOptional  = service.update(id, product);
        
        if(productOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(productOptional.orElseThrow());
        }else{
            return ResponseEntity.notFound().build(); // -> 404
        }
    }


    @DeleteMapping("/{id}") // -> ESTO ES UN PATH VARIABLE, ES DECIR QUE CAMBIA Y PARA ANOTAR QUE LO QUE BUSCO /ID ES LO QUE QUIERO INYECTAR EN ID
    public ResponseEntity<?> delete(@PathVariable Long id){ // HAGO UN @PATHVARIABLE

        Optional<Product> productOptional = service.delete(id);
        
        if(productOptional.isPresent()){
            return ResponseEntity.ok(productOptional.orElseThrow()); // -> si exsite ese producto lo devolvemos ELSE
        }else{
            return ResponseEntity.notFound().build(); // -> ERROR 404
        }

    }

    private ResponseEntity<?> validation(BindingResult result) {
        
        Map<String,String> errors = new HashMap<>();

        result.getFieldErrors().forEach(e -> {
            errors.put(e.getField(), e.getDefaultMessage());
        });
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
