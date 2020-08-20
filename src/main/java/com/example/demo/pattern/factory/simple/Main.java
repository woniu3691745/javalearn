package com.example.demo.pattern.factory.simple;

import com.example.demo.pattern.factory.IProduct;

/**
 * @author lidongliang
 * create at: 2020/8/20  11:44 上午
 */
public class Main {

    public static void main(String[] args) {
        IProduct iProductA = Factory.createProduct("A");
        iProductA.method();
        IProduct iProductB = Factory.createProduct("B");
        iProductB.method();
    }
}
