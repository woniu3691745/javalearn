package com.example.demo.pattern.proxy.statics;

import com.example.demo.pattern.proxy.IDBQuery;

/**
 * @author lidongliang
 * create at: 2020/8/13  5:10 下午
 * <p>
 * 客户端，使用代理类和主题接口完成一些工作。
 */
public class Main {

    public static void main(String[] args) {
        IDBQuery q = new DBQueryProxy();// 使用代理类
        System.out.println(q.request());// 在真正使用时才创建真实对象
    }
}
