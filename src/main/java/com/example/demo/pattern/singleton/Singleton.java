package com.example.demo.pattern.singleton;

/**
 * @author lidongliang
 * create at: 2020/8/17  2:30 下午
 * <p>
 * 单例模式基本实现
 * <p>
 * <p>
 * 入门级的单例写法像下面这样，这种方式的弊端明显，对象在类被加载的时候就实例化，对于消耗资源的类型来说不适用这种方式，像文件系统/数据库。
 * 同时如果在使用到反射来实例化对象的场景下，这种写法也是线程不安全的，它避免不了生成多个实例。
 */
public class Singleton {

    /**
     * instance 成员变量和 getInstance 方法必须是 static 的
     */
    private static Singleton instance = new Singleton();

    /**
     * 首先单例类必须要有一个 private 访问级别的构造函数
     * 才能确保单例不会在系统中的其他代码内被实例化
     */
    private Singleton() {
        System.out.println("Singleton is create");
    }

    public static Singleton getInsatnce() {
        return instance;
    }

}

