package com.example.demo.pattern.proxy.dynamic;

import com.example.demo.pattern.proxy.DBQuery;
import com.example.demo.pattern.proxy.IDBQuery;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lidongliang
 * create at: 2020/8/13  5:16 下午
 * <p>
 * JDK动态代理
 */
public class DBQueryHandler implements InvocationHandler {

    DBQuery realQuery = null; // 定义主题接口

    /**
     * 🌟创建代理对象🌟
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 如果第一次调用，生成真实主题
        if (realQuery == null) {
            realQuery = new DBQuery();
        }

        // 返回真实主题完成实际的操作
        return realQuery.request();
    }

    /**
     * 🌟生成动态代理对象🌟
     * 由 newProxyInstance() 方法返回该代理类的一个实例
     *
     * @return IDBQuery
     */
    public static IDBQuery createProxy() {
        IDBQuery proxy = (IDBQuery) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader()
                , new Class[]{IDBQuery.class}, new DBQueryHandler());
        return proxy;
    }
}
