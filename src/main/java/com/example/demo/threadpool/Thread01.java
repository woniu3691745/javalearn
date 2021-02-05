package com.example.demo.threadpool;

/**
 * @author lidongliang
 * create at: 2021/2/1  1:59 下午
 * <p>
 * Thread demo
 */
public class Thread01 {

    public static void main(String[] args) {
        Thread thread = new Thread(new Thread02(), "thread01");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.start();
    }

}

class Thread02 extends Thread {
    @Override
    public void run() {
        System.out.println("thread-name : " + Thread.currentThread().getName());
    }
}