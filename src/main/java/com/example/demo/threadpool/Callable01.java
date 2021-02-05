package com.example.demo.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author lidongliang
 * create at: 2021/2/1  2:12 下午
 * <p>
 * Callable demo
 * callable 需要与FutureTask结合使用
 * task.get() 阻塞获得返回值
 */
public class Callable01 {

    public static void main(String[] args) {
        FutureTask<String> task = new FutureTask<>(new Callable02());
        try {
            Thread thread = new Thread(task, "Callable");
            thread.start();
            System.out.println(task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class Callable02 implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "Thread-name : " + Thread.currentThread().getName();
    }
}
