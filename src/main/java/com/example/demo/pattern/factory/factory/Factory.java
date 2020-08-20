package com.example.demo.pattern.factory.factory;

import com.example.demo.pattern.factory.IProduct;

/**
 * @author lidongliang
 * create at: 2020/8/20  11:51 上午
 * <p>
 * 抽象工厂类(抽象类或接口)
 * <p>
 * 工厂模式有一个抽象工厂类对应多个具体工厂实现类;
 * <p>
 * 一个抽象产品类对应一个具体实现类;
 * <p>
 * 并且每个具体工厂类只能创建一个具体产品类的实例;
 * <p>
 * <p>
 * 优点：克服了简单工厂违背开放-封闭原则的缺点，又保留了封装对象创建过程的优点,降低客户端和工厂的耦合性，所以说“工厂模式”是“简单工厂模式”的进一步抽象和推广
 * <p>
 * <p>
 * 🌟🌟缺点：每增加一个产品，相应的也要增加一个子工厂，加大了额外的开发量。🌟🌟
 */
public abstract class Factory {

    /**
     * 抽象工厂方法
     * 具体产生什么由子类决定
     *
     * @return 具体产品对象
     */
    public abstract IProduct createProduct();

}
