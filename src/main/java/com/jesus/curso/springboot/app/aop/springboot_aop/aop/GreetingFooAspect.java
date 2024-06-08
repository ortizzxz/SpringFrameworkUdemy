package com.jesus.curso.springboot.app.aop.springboot_aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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

    @Pointcut("execution(String com.jesus.curso.springboot.app.aop.springboot_aop.services.GreetingService.sayHello(..))")
    private void greetingFooLoggerAspectPointCut(){}

    @Before("greetingFooLoggerAspectPointCut()") 
    public void loggerBefore(JoinPoint joinPoint){

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes: " + method + ", con los argumentos : " + args);
    }
}
