package com.example.demo.jvm.objecthead;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lidongliang
 * create at: 2020/9/22  11:04 上午
 */
@Slf4j(topic = "lidongliang")
public class CutDownLatchMain1 {

    public static void main(String[] args) throws InterruptedException {

        List<String> list = new ArrayList<>();
        list.add("Angel");
        list.add("baby");
        list.add("rose");
        list.add("joyce");

//        List<String> tempo = new ArrayList<>();

        AtomicInteger i = new AtomicInteger();

        ExecutorService service = Executors.newFixedThreadPool(4, (runnable) -> new Thread(runnable, list.get(i.getAndIncrement())));

        CountDownLatch latch = new CountDownLatch(4);
        Random random = new Random();
        for (int j = 0; j < 4; j++) {
            int temp = j;
            service.submit(() -> {
                for (int k = 0; k < 100; k++) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(random.nextInt(200));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    String name = Thread.currentThread().getName();
                    name = name + "(" + k + ")";
                    list.set(temp, name);
                    System.out.print("\r" + Arrays.toString(list.toArray()));
                }
                latch.countDown();
            });
        }
        latch.await();
        System.out.println("\n start");
        service.shutdownNow();


        ThreadPoolExecutor threadPoolExecutor
                = new ThreadPoolExecutor(
                1
                , 2
                , 3
                , TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1));

        threadPoolExecutor.execute(() -> System.out.println("2"));


    }
}
