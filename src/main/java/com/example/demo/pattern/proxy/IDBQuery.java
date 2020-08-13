package com.example.demo.pattern.proxy;

/**
 * @author lidongliang
 * create at: 2020/8/13  4:59 下午
 * <p>
 * 主题接口：定义代理类和真实主题的公共对外方法，也是代理类代理真实主题的方法；
 */
public interface IDBQuery {

    String request();

}
