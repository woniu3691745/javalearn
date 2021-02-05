package com.example.demo.pattern.proxy.dynamic;

import com.example.demo.pattern.proxy.DBQuery;

/**
 * @author lidongliang
 * create at: 2020/8/13  5:10 下午
 * <p>
 * 客户端，使用代理类和主题接口完成一些工作。
 */
public class Main {

    public static void main(String[] args) {
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        String request = DBQueryHandler.createProxy().request();
        System.out.println(request);

    }


}
