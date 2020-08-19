package com.example.demo.pattern.decorator;

/**
 * @author lidongliang
 * <p>
 * <p>
 * 定义装饰器/负责权限装饰  ---> 装饰器
 */
abstract class Decorator implements Component {

    protected Component component;

    /**
     * 🌟🌟这里传入基础的管理员，才会保证原有结构
     *
     * @param component
     */
    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void identity() {
        //这里是执行原有的功能
        component.identity();
    }
}