Some examples of common pointcut expressions are given below.

the execution of any public method:
任何公共方法的执行：
execution(public * *(..))

the execution of any method with a name beginning with "set":
名称以“ set”开头的任何方法的执行：
execution(* set*(..))

the execution of any method defined by the AccountService interface:
由AccountService接口定义的任何方法的执行：
execution(* com.xyz.service.AccountService.*(..))

the execution of any method defined in the service package:
服务包中定义的任何方法的执行：
execution(* com.xyz.service.*.*(..))

the execution of any method defined in the service package or a sub-package:
服务包或子包中定义的任何方法的执行：
execution(* com.xyz.service..*.*(..))

any join point (method execution only in Spring AOP) within the service package:
服务包中的任何连接点（仅在Spring AOP中执行方法）：
within(com.xyz.service.*)

any join point (method execution only in Spring AOP) within the service package or a sub-package:
服务包或子包中的任何连接点（仅在Spring AOP中执行方法）：
within(com.xyz.service..*)

any join point (method execution only in Spring AOP) where the proxy implements the AccountService interface:
代理实现AccountService接口的任何连接点（仅在Spring AOP中执行方法）：
this(com.xyz.service.AccountService)