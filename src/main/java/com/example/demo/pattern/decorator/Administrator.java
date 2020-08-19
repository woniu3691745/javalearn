package com.example.demo.pattern.decorator;

/**
 * @author lidongliang
 * create at: 2020/8/19  5:12 下午
 * <p>
 * 定义一个基础类/基础管理员
 */
public class Administrator implements Component {

    @Override
    public void identity() {
        System.out.println("我是管理员，我现在只有身份没有权限");
    }

}
