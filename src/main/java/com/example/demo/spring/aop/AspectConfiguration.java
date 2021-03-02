package com.example.demo.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author lidongliang
 * create at: 2021/2/7  5:50 下午
 */
@Aspect
public class AspectConfiguration {

    @Pointcut("execution(public * *(..))") // 匹配 Joint Point
    private void anyPublicMethod() { // 方法名即 Pointcut 名
//        System.out.println("anyPublicMethod");
    }

    @Before("anyPublicMethod()") // Join Point 拦截动作
    public void beforeAnyPublicMethod() {
        System.out.println("beforeAnyPublicMethod");
    }

    @Around("anyPublicMethod()")
    public Object aroundPublicMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = null;
        if (joinPoint.getClass().isAssignableFrom(Object.class)) {
            System.out.println("aroundPublicMethod >>> ");
            proceed = joinPoint.proceed();
            System.out.println("aroundPublicMethod <<< ");
        }
        return proceed;
    }

}
