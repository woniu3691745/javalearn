package com.example.demo.pattern.factory.simple;

import com.example.demo.pattern.factory.IProduct;
import com.example.demo.pattern.factory.ProductA;
import com.example.demo.pattern.factory.ProductB;

/**
 * @author lidongliang
 * create at: 2020/8/20  11:39 上午
 * <p>
 * 工厂类-简单工厂模式(🌟静态工厂方法)
 * <p>
 * <p>
 * 1、优点: 强调职责单一原则，一个类只提供一种功能。
 * <p>
 * 2、缺点: 一旦对工厂类修改就违反了开闭原则。
 */
public class Factory {

    /**
     * 🌟🌟🌟简单工厂模式 只有一个静态方法提供产品所以也叫静态工厂方法
     *
     * @param productName 产品名字
     * @return 产品
     */
    public static IProduct createProduct(String productName) {
        switch (productName) {
            case "A":
                return new ProductA();
            case "B":
                return new ProductB();
            default:
                return null;
        }
    }
}
