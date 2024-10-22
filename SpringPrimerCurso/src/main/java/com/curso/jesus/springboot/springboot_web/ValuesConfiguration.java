package com.curso.jesus.springboot.springboot_web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource(value="classpath:values.properties", encoding="UTF-8") //esto es para importar las configuraciones de mi values.property
    })
public class ValuesConfiguration {

}
