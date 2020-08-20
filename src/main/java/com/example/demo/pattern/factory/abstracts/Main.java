package com.example.demo.pattern.factory.abstracts;

/**
 * @author lidongliang
 * create at: 2020/8/20  12:08 下午
 */
public class Main {

    public static void main(String[] args) {
//        Factory factory = new AFactory();
        Factory factory = new BFactory();

        IDrink cola = factory.createDrinkProduct();
        cola.method();
        IFood riceFood = factory.createFoodProduct();
        riceFood.method();


    }
}
