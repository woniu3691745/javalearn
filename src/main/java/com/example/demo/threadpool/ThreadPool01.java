package com.example.demo.threadpool;

import java.util.concurrent.*;

/**
 * @author lidongliang
 * create at: 2021/2/1  2:19 下午
 * <p>
 * 线程池
 */
public class ThreadPool01 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 创建一个线程池，该线程池根据需要创建新线程，但是将在先前构造的线程可用时重用它们。
        // 这些池通常将提高执行许多短暂的异步任务的程序的性能。如果可用，execute将重用以前构造的线程。
        // 如果没有可用的现有线程，则将创建一个新线程并将其添加到池中。六十秒内未使用的线程将终止并从缓存中删除。
        // 因此，保持空闲时间足够长的池不会消耗任何资源.
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.execute(
                () -> {
                    // ... do something inside runnable task
                    System.out.println(Thread.currentThread().getName() + " is running ..");

                });
        cachedThreadPool.shutdown();
        Future<?> submit = cachedThreadPool.submit(() -> {
            // ... do something inside runnable task
            System.out.println(Thread.currentThread().getName() + " is running ..");

        });
        submit.get();

        // 创建一个执行程序，该执行程序使用在不受限制的队列上操作的单个工作线程。
        // （但是请注意，如果该单线程由于在关闭之前的执行期间失败而终止，则在需要执行新任务时将替换为新线程。）
        // 保证任务按顺序执行，并且活动的任务不超过一个在任何给定时间。
        // 与其他等效的newFixedThreadPool(1)不同，保证返回的执行程序不能重新配置为使用其他线程
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.execute(() -> {
            // ... do something inside runnable task
            System.out.println(Thread.currentThread().getName() + " is running ..");

        });

        // 创建一个线程池，该线程池可以安排命令在给定的延迟后运行或定期执行。
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);


        // 创建一个线程池，该线程池重用在共享的无边界队列上运行的固定数量的线程。
        // 在任何时候，最多nThreads线程都是活动的处理任务。
        // 如果在所有线程都处于活动状态时提交了其他任务，则它们将在队列中等待，直到某个线程可用为止。
        // 如果在关闭之前执行过程中由于执行失败导致任何线程终止，则在执行后续任务时将使用新线程代替。
        // 池中的线程将一直存在，直到将其显式shutdown为止
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        while (true) {
            // 提交多个线程任务，并执行
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " is running ..");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }
}
