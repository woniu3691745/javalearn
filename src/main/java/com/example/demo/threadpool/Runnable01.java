package com.example.demo.threadpool;

/**
 * @author lidongliang
 * create at: 2021/2/1  2:08 下午
 * <p>
 * Runnable demo
 */
public class Runnable01{

    public static void main(String[] args) {
        new Thread(new Runnable02(), "Runnable02").start();
    }
}

class Runnable02 implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread-name : "+Thread.currentThread().getName());
    }
}
