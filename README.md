# Introduction to AOP

Applications are generally developed with multiple layers. A typical Java application has:

Web Layer: Exposing services to the outside world using REST or a web application
Business Layer: Business logic
Data Layer: Persistence logic
While the responsibilities of each of these layers are different, there are a few common aspects that apply to all layers

Logging
Security
These common aspects are called cross-cutting concerns.

One option of implementing cross-cutting concerns is to implement them separately in every layer. However, that would make the code difficult to maintain.

Aspect Oriented Programming provides a solution for implementing cross-cutting concerns.

Implement the cross-cutting concern as an aspect.
Define pointcuts to indicate where the aspect has to be applied.
This ensures that the cross-cutting concerns are defined in one cohesive code component and can be applied as needed.

# Spring-Boot-AOP

Spring AOP (Aspect-oriented programming) framework is used to modularize cross-cutting concerns in aspects. Put it simple, it’s just an interceptor to intercept some processes, for example, when a method is execute, Spring AOP can hijack the executing method, and add extra functionality before or after the method execution.

In Spring AOP, 4 type of advices are supported :

Before advice – Run before the method execution

After returning advice – Run after the method returns a result

After throwing advice – Run after the method throws an exception

Around advice – Run around the method execution, combine all three advices above.
