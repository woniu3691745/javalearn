package com.example.demo.pattern.proxy.cglib;

/**
 * @author lidongliang
 * create at: 2020/8/13  5:39 下午
 */
public class Main {

    public static void main(String[] args) {

//        BookProsyLib cglib = new BookProsyLib();
//        BookProxyImpl instance = (BookProxyImpl)cglib.getInstance(new BookProxyImpl());
//        instance.addBook();

//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/lidongliang/project/javalearn");
        BookProxyLib cglib = new BookProxyLib();
        BookProxyImpl2 instance = (BookProxyImpl2)cglib.getInstance(new BookProxyImpl2());
//        instance.addBook();
        instance.addBook1();
    }
}
