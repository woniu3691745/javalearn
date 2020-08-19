package com.example.demo.pattern.decorator;

/**
 * @author lidongliang
 * create at: 2020/8/19  5:14 下午
 */
public class Main {

    public static void main(String[] args) {

        // 原有的功能 new Administrator()
        Component component = new DeA(new Administrator());
        component.identity();
        Component component1 = new DeB(new Administrator());
        component1.identity();
//        Decorator decorator = new Decorator(new Administrator());

    }

}
