package com.example.demo.pattern.adapter;

/**
 * @author lidongliang
 * 已经存在的接口，这个接口需要配置
 */
public class Adaptee {

    /**
     * 原本存在的方法
     */
    public void specificRequest() {
        System.out.println("specificRequest");
    }

}
