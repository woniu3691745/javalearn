package com.example.demo.pattern.decorator;

/**
 * @author lidongliang
 * create at: 2020/8/19  5:14 下午
 */
class DeB extends Decorator {

    public DeB(Component component) {
        super(component);
    }

    @Override
    public void identity() {
        //保证原有结构
        this.component.identity();
        administration();
    }

    /**
     * 扩展装饰具体的实现逻辑
     */
    public void administration() {
        System.out.println("我负责行政");
    }

}