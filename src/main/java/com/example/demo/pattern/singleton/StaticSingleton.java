package com.example.demo.pattern.singleton;

/**
 * @author lidongliang
 * create at: 2020/8/17  2:36 下午
 * <p>
 * 解决同步关键字低效率
 */
public class StaticSingleton {

    private StaticSingleton() {
        System.out.println("StaticSingleton is create");
    }

    private static class SingletonHolder {
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }

}
