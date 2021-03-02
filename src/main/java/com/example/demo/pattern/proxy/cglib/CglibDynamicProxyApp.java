package com.example.demo.pattern.proxy.cglib;

import com.example.demo.pattern.proxy.DBQuery;
import com.example.demo.pattern.proxy.IDBQuery;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * nˈhansər
 * CGLIB 字节码提升
 *
 * @author lidongliang
 * create at: 2021/2/7  10:38 上午
 */
public class CglibDynamicProxyApp {

    public static void main(String[] args) {
        // step1. 创建enhance
        Enhancer enhancer = new Enhancer();
        // step2. 获得被代理的接口实现类
        Class<?> superClass = DBQuery.class;
        // step3. 设置代理类 enhance 的父类
        enhancer.setSuperclass(superClass);
        // step3. 设置代理类的接口类
        enhancer.setInterfaces(new Class[]{IDBQuery.class});
        // step4. 调用    MethodInterceptor
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object source, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                // Source -> CGLIB 子类
                // 目标类 -> DefaultEchoService
                // 错误使用
                // Object invoke1 = method.invoke(source, args);
                // 正确的方法使用
                System.out.println("事物开始");
                Object invoke = methodProxy.invokeSuper(source, args);
                System.out.println("事物结束");
                return null;
            }
        });

        // step5. 创建代理对象
        IDBQuery idbQuery = (IDBQuery) enhancer.create();
        idbQuery.request("李栋梁快跑！");

    }

}
