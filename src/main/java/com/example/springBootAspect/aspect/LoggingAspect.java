package com.example.springBootAspect.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Arrays;

@Aspect
@Component
//@Configuration
public class LoggingAspect {

    private static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class);

    /*
        Pointcut: the expression used to define when a call to a method should be intercepted.
        In the example, execution(* com.example.springBootAspect.controller.EmployeeController.*(..)))
        is the pointcut.

        what is mean ? A Pointcut is a predicate that helps match an Advice to be applied by an
        Aspect at a particular JoinPoint.
        The Advice is often associated with a Pointcut expression and runs at any Joinpoint
        matched by the Pointcut.

        Advice: What do you want to do? An advice is the logic that you want to invoke when
        you intercept a method. In the above example, it is the code inside
        the beforeAdvice(JoinPoint joinPoint) method.

        what is mean ? An advice is an action taken by an aspect at a particular Joinpoint.
        Different types of advice include “around,” “before” and “after” advice.
        In Spring, an Advice is modeled as an interceptor, maintaining a chain of
        interceptors around the Joinpoint.

        Aspect: A combination of defining when you want to intercept a method call (Pointcut)
        and what to do (Advice) is called an Aspect.

        Join Point: When the code is executed and the condition for pointcut is met,
        the advice is executed. The Join Point is a specific execution instance of an advice.

        what is mean ? A Join point is a point during the execution of a program, such as execution of
        a method or the handling of an exception.
        In Spring AOP, a JoinPoint always represents a method execution.

        Weaver: Weaver is the framework that implements AOP — AspectJ or Spring AOP.
     */
    @Before(value = "execution(* com.example.springBootAspect.controller.EmployeeController.*(..)))")
    public void beforeAdvice(JoinPoint joinPoint){

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        //Get intercepted method details
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        //get parameter name
        System.out.println(Arrays.toString(methodSignature.getParameterNames()));

        // logging
        LOGGER.info("call " + methodName + " method in " + className);

        // get argument value
        Object[] objects = joinPoint.getArgs();
        System.out.println(Arrays.toString(objects));
        System.out.println(joinPoint.toString());

    }

    /*
        @After: executed in two situations — when a method executes successfully or it throws an exception.
        @AfterReturning: executed only when a method executes successfully.
        @AfterThrowing: executed only when a method throws an exception.
     */
    @After(value = "execution(* com.example.springBootAspect.controller.EmployeeController.*(..)))")
    public void afterAdvice(JoinPoint joinPoint){

        // logging
        LOGGER.info("finish method");

    }

//    @Around : Advice that surrounds a join point such as a method invocation.
    @Around(value = "execution(* com.example.springBootAspect.controller.EmployeeController.*(..)))")
    public Object AroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();

        //Log method execution time
        LOGGER.info("Execution time of "
                + ":: " + stopWatch.getTotalTimeMillis() + " ms");

        return result;
//        return ResponseEntity.ok("result");

    }

}
