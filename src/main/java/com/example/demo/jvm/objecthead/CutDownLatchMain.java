package com.example.demo.jvm.objecthead;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lidongliang
 * create at: 2020/9/22  11:04 上午
 */
@Slf4j(topic="lidongliang")
public class CutDownLatchMain {

    public static void main(String[] args) throws InterruptedException {

        AtomicInteger a = new AtomicInteger();
        ExecutorService service = Executors.newFixedThreadPool(4, (zl) -> new Thread(zl, "tt" + a.incrementAndGet()));

        CountDownLatch latch = new CountDownLatch(3);

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap<>(32);


        service.submit(()->{
            log.debug("--t111 start--");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
            log.debug("--t111 end-- count -- {}", latch.getCount());
        });


        new Thread(()->{
            log.debug("--t2 start--");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
            log.debug("--t2 end-- count -- {}", latch.getCount());
        },"t2").start();

        new Thread(()->{
            log.debug("--t3 start--");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
            log.debug("--t3 end -- count -- {}", latch.getCount());
        },"t3").start();

        log.debug("main waiting");
        latch.await();
        log.debug("main waiting end ...");
    }
}
