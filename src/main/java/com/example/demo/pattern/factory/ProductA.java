package com.example.demo.pattern.factory;

/**
 * @author lidongliang
 * create at: 2020/8/20  11:38 上午
 * <p>
 * A产品
 */
public class ProductA implements IProduct {
    @Override
    public void method() {
        System.out.println("ProductA");
    }
}
