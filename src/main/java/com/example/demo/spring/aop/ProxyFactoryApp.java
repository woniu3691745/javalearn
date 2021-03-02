package com.example.demo.spring.aop;

import com.example.demo.pattern.proxy.DBQuery;
import com.example.demo.pattern.proxy.IDBQuery;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.AopContext;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * JDKProxy MethodInterceptor > invoke
 *
 * @author lidongliang
 * create at: 2021/2/9  10:42 上午
 */
public class ProxyFactoryApp {

    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory(new DBQuery());
        factory.addInterface(IDBQuery.class);
        factory.addAdvice(new MethodInterceptorDemo());// 调用
        IDBQuery idbQuery = (IDBQuery) factory.getProxy();
        // this is a method call on the proxy!
        idbQuery.request("ProxyFactory ...");
    }
}

class MethodInterceptorDemo implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
//        System.out.println("method " + invocation.getMethod() + " is called on " +
//                invocation.getThis() + " with args " + Arrays.toString(invocation.getArguments()));
        System.out.println("start");
        Object ret = invocation.proceed();
//        System.out.println("method " + invocation.getMethod() + " returns " + ret);
        System.out.println("end");
        return ret;
    }
}
