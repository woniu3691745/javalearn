package com.example.demo.pattern.singleton;

/**
 * @author lidongliang
 * create at: 2020/8/17  2:32 下午
 * <p>
 * 延迟加载的单例模式
 * <p>
 * <p>
 * 懒加载这种写法，在单线程情况下没问题，但是如果出现多线程的情况，那么单例就会失效。
 * 对于多线程的情况，很自然的我们会想直接给 getInstance()方法加个同步块就可以解决，
 * 但是在90%的情况下是不需要同步的，只有在第一次实例化的时候才需要。
 */
public class LazySingleton {

    private static LazySingleton mInstance = null;

    private LazySingleton() {
    }

    public static LazySingleton getIsntance() {
        if (mInstance == null) {
            mInstance = new LazySingleton();
        }
        return mInstance;
    }

}
