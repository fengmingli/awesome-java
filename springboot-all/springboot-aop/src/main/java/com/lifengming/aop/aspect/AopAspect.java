package com.lifengming.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * execution(modifiers-pattern ? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern)throws-pattern?)
 *          修饰符 ？返回值匹配 类路径匹配？方法名匹配（参数匹配）
 * 多个参数间用“,”隔开，各个参数也可以用"*" 来表示匹配任意类型的参数，".."表示零个或多个任意参数。
 * execution(public * *(..))
 * execution(* set*(..))
 *
 * @author lifengming
 * @since 2019.12.20
 */
@Aspect
@Component
public class AopAspect {

    @Pointcut("@annotation(com.lifengming.aop.annotation.AopLog)")
    public void aop() {
        //no op
    }

    @Pointcut("execution(* set*(..))")
    public void aop2() {
        //no op
    }

    @Before("aop()")
    public void before(JoinPoint joinPoint) {
        System.out.println("============before==========");
    }

}
