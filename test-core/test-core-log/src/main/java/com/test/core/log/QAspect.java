package com.test.core.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;


@Aspect
@Configuration
public class QAspect {


    @Before(value = "execution(* *(..)) and @annotation(logAnnotation)", argNames = "logAnnotation")
    public void logBefore(JoinPoint call, Test logAnnotation) {
    	
    	System.out.println("@Before");
    }

    @AfterReturning(pointcut = "execution(* *(..)) and @annotation(logAnnotation)", returning = "returnValue", argNames = "logAnnotation, returnValue")
    public void logReturn(JoinPoint call, Test logAnnotation,Object returnValue) {
    	System.out.println("@AfterReturning");
    	
    	
    }

    @AfterThrowing(pointcut = "execution(* *(..)) and @annotation(logAnnotation)", throwing = "exception", argNames = "logAnnotation, exception")
    public void logException(JoinPoint call, Test logAnnotation,Throwable exception) {
    	System.out.println("@AfterThrowing");
    	
    	
    }

}
