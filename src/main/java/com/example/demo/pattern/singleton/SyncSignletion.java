package com.example.demo.pattern.singleton;

/**
 * @author lidongliang
 * create at: 2020/8/17  2:45 下午
 * <p>
 * 双重检查锁定
 */
public class SyncSignletion {

    // 这种写法才能保证线程安全。一个使用了 volatile关键字的双重检查锁定才算是一个真正的DCL(double checked locking)
//    private static volatile SyncSignletion syncSignletion = null;

    private static SyncSignletion syncSignletion = null;

    private SyncSignletion() {
    }

    public static SyncSignletion getIsntance() {
        if (syncSignletion == null) {
            synchronized (SyncSignletion.class) {
                if (syncSignletion == null) {
                    syncSignletion = new SyncSignletion();
                }
            }
        }
        return syncSignletion;
    }
}
