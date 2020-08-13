package com.example.demo.pattern.proxy.statics;

import com.example.demo.pattern.proxy.DBQuery;
import com.example.demo.pattern.proxy.IDBQuery;

/**
 * @author lidongliang
 * create at: 2020/8/13  5:06 下午
 * <p>
 * 代理类：用来代理和封装真实主题；
 */
public class DBQueryProxy implements IDBQuery {

    private DBQuery real = null;

    @Override
    public String request() {
        // 在真正需要的时候才能创建真实对象，创建过程可能很慢
        if (real == null) {
            real = new DBQuery();
        }
        return real.request();
    }
}
