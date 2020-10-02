package com.example.springBootAspect.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CommonPointCut {

    @Pointcut("execution(* com.example.springBootAspect.controller.EmployeeController.*(..)))")
    public void employeeControllerLog(){}

    /*
        we want to consider all the methods within the classes defined in package com.example and subpackage it
     */
    @Pointcut("within(com.example..*)")
    public void employeeControllerLog3(){}
}
