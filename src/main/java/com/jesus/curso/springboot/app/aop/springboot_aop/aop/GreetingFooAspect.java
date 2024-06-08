package com.jesus.curso.springboot.app.aop.springboot_aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Order(1)
@Component
@Aspect
public class GreetingFooAspect {
    private Logger logger =  LoggerFactory.getLogger(getClass());

    @Before("execution(String com.jesus.curso.springboot.app.aop.springboot_aop.services.GreetingService.sayHello(..))") // (..) -> expresion regular
    public void loggerBefore(JoinPoint joinPoint){

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes: " + method + ", con los argumentos : " + args);
    }
}
