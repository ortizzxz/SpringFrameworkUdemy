package com.jesus.curso.springboot.app.aop.springboot_aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointCuts {
    @Pointcut("execution(String com.jesus.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))") // (..) -> expresion regular
    private void greetingLoggerPointCut(){}

    @Pointcut("execution(String com.jesus.curso.springboot.app.aop.springboot_aop.services.GreetingService.sayHello(..))")
    private void greetingFooLoggerAspectPointCut(){}
}
