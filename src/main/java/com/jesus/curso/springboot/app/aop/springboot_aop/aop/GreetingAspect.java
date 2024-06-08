package com.jesus.curso.springboot.app.aop.springboot_aop.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(2)
@Aspect
@Component
public class GreetingAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(String com.jesus.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))") // (..) -> expresion regular
    private void greetingLoggerPointCut(){}

    //@Before("execution(String com.jesus.curso.springboot.app.aop.springboot_aop...*.*(..))")   
    //@Before("execution(String com.jesus.curso.springboot.app.aop.springboot_aop.services.*.*(..))")   
    //@Before("execution(String com.jesus.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")   
    @Before("greetingLoggerPointCut()") 
    public void loggerBefore(JoinPoint joinPoint){

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes: " + method + ", con los argumentos : " + args);
    }
 
    @AfterReturning("greetingLoggerPointCut()")
    public void loggerAfterReturning(JoinPoint joinPoint){

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Después de retornar: " + method + ", con los argumentos : " + args);
    }
    
    @AfterThrowing("greetingLoggerPointCut()")
    public void loggerAfterThrow(JoinPoint joinPoint){

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Después de lanzar la excepción: " + method + ", con los argumentos : " + args);
    }

    @Around("greetingLoggerPointCut()")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable{

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());


        Object result = null;

        try {
            logger.info("El metodo es: " + method + "() con los parametros: " + args);

            result = joinPoint.proceed();

            logger.info("El metodo es: " + method + "() retorna el resultado: " + result);
            return result;
        }catch (Throwable e) {

            logger.error("Error en la llamada del metodo" + method);
            throw e;
        }

}
}
