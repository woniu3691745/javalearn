package com.example.demo.pattern.proxy.dynamic;

import com.example.demo.pattern.proxy.DBQuery;
import com.example.demo.pattern.proxy.IDBQuery;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lidongliang
 * create at: 2021/2/5  3:43 下午
 */
public class DynamicDemoApplication {

    public static void main(String[] args) {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Object proxyInstance = Proxy.newProxyInstance(classLoader, new Class[]{IDBQuery.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (IDBQuery.class.isAssignableFrom(method.getDeclaringClass())) {
                    DBQuery dbQuery = new DBQuery();
                    return dbQuery.request(String.valueOf(args[0]));
                }
                return null;
            }
        });

        IDBQuery idbQuery = (IDBQuery)proxyInstance;
        idbQuery.request("李栋梁给点力！");
    }
}
