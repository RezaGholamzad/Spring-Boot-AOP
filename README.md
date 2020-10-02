# Spring-Boot-AOP

Spring AOP (Aspect-oriented programming) framework is used to modularize cross-cutting concerns in aspects. Put it simple, it’s just an interceptor to intercept some processes, for example, when a method is execute, Spring AOP can hijack the executing method, and add extra functionality before or after the method execution.

In Spring AOP, 4 type of advices are supported :

Before advice – Run before the method execution

After returning advice – Run after the method returns a result

After throwing advice – Run after the method throws an exception

Around advice – Run around the method execution, combine all three advices above.
