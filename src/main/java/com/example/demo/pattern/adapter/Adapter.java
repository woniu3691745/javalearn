package com.example.demo.pattern.adapter;

/**
 * @author lidongliang
 * 适配器类
 */
public class Adapter implements Target {

    /**
     * 持有需要被适配的接口对象
     */
    private Adaptee adaptee;

    /**
     * 构造方法，传入需要被适配的对象
     * @param adaptee 需要被适配的对象
     */
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        // 使原有接口和新的接口关联上
        // 新业务和老业务集成在一起
        adaptee.specificRequest();
    }
}
