package com.example.demo.pattern.proxy.cglib;

/**
 * @author lidongliang
 * create at: 2020/8/13  5:31 下午
 * <p>
 * 定义实现类
 */
public class BookProxyImpl implements BookProxy {

    @Override
    public void addBook() {
        System.out.println("增加图书馆普通方法");
    }

}
