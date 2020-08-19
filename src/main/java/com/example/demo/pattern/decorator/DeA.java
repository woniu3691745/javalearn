package com.example.demo.pattern.decorator;

/**
 * @author lidongliang
 * create at: 2020/8/19  5:13 下午
 */
class DeA extends Decorator {

    public DeA(Component component) {
        super(component);
    }

    @Override
    public void identity() {
        //保证原有结构
        this.component.identity();
        personnelFile();
    }

    /**
     * 扩展装饰具体的实现逻辑
     */
    public void personnelFile() {
        System.out.println("我负责人事");
    }

}
