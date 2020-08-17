package com.example.demo.pattern.singleton;

/**
 * @author lidongliang
 * create at: 2020/8/17  2:53 下午
 * <p>
 * 枚举
 * <p>
 * <p>
 * 枚举单例其实是利用了Java的特性，在Java中，任何的枚举都只会被实例化一次，虽然这样保证了绝对的单例，
 * 但是失去了懒加载的特性。所以在部分需要考虑资源消耗而使用懒加载的场景下，就不适合用枚举单例了。
 */
public enum EnumSingleton {

    INSTANCE;

    public static void foo() {
        //do whatever you want
    }

}
