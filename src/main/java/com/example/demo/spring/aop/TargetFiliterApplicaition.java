package com.example.demo.spring.aop;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * @author lidongliang
 * create at: 2021/2/5  4:14 下午
 */
public class TargetFiliterApplicaition {

    public static void main(String[] args) throws ClassNotFoundException {

        String targetClassName = "com.example.demo.pattern.proxy.IDBQuery";
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?> loadClass = classLoader.loadClass(targetClassName);
        // spring 反射工具类
        Method request = ReflectionUtils.findMethod(loadClass, "request", String.class);
        System.out.println(request);

    }
}
