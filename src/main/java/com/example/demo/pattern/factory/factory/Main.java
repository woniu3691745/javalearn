package com.example.demo.pattern.factory.factory;

import com.example.demo.pattern.factory.IProduct;

/**
 * @author lidongliang
 * create at: 2020/8/20  11:57 上午
 */
public class Main {

    public static void main(String[] args) {
        Factory afactory = new AFactory();
        IProduct aproduct = afactory.createProduct();
        aproduct.method();

        Factory bfactory = new BFactory();
        IProduct bproduct = bfactory.createProduct();
        bproduct.method();
    }
}