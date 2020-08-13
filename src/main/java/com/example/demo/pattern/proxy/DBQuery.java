package com.example.demo.pattern.proxy;

/**
 * @author lidongliang
 * create at: 2020/8/13  5:02 下午
 * <p>
 * 真实主题：真正实现业务逻辑的类；
 */
public class DBQuery implements IDBQuery {

    public DBQuery() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String request() {
        return "request string";
    }
}
