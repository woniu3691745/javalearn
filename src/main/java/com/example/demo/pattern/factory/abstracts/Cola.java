package com.example.demo.pattern.factory.abstracts;

/**
 * @author lidongliang
 * create at: 2020/8/20  12:05 下午
 * <p>
 * 可乐
 */
public class Cola implements IDrink {
    @Override
    public void method() {
        System.out.println("可乐");
    }
}
