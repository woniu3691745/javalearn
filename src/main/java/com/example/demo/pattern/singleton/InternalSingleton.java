package com.example.demo.pattern.singleton;

/**
 * @author lidongliang
 * create at: 2020/8/17  2:49 下午
 * <p>
 * 静态内部类
 * <p>
 * 这种写法的优势是，它既提供了懒加载的特性，又避免了使用同步块的开销。
 * 在Singleton类被加载的时候，内部静态类直到 getInstance()被调用前都不会加载，
 * 而静态类被加载后只会实例化一次单例。
 */
public class InternalSingleton {

//    private static InternalSingleton internalSingleton = null;

    private InternalSingleton() {
    }

    // 内部类
    private static class InternalSingleton_ {
        private static final InternalSingleton INSTANCE = new InternalSingleton();
    }

    public static InternalSingleton getIsntance() {
        return InternalSingleton_.INSTANCE;
    }
}
