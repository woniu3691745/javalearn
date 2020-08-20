package com.example.demo.pattern.factory.abstracts;

/**
 * @author lidongliang
 * create at: 2020/8/20  12:06 下午
 * <p>
 * 抽象工厂类(抽象类或接口)
 */
public abstract class Factory {
    /**
     * 抽象工厂方法
     * 具体产生什么由子类决定
     *
     * @return 具体产品对象
     */
    public abstract IFood createFoodProduct();

    public abstract IDrink createDrinkProduct();

}
