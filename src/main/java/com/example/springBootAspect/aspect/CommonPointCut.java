package com.example.springBootAspect.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointCut {

    @Pointcut("execution(* com.example.springBootAspect.controller.EmployeeController.*(..)))")
    public void employeeControllerLog(){}

    /*
        we want to consider all the methods within the classes defined in package com.example and subpackage it
     */
    @Pointcut("within(com.example..*)")
    public void employeeControllerLog3(){}
}
