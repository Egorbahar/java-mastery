package com.godeltech.l3pt2.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class CustomThreadExecutor {
    private static final int THREAD_POOL_NUMBER = 4;

    public static void invoke() {
        final List<Long> list = new ArrayList<>();
        final AtomicReference<Long> totalPerformanceMillis = new AtomicReference<>((long) 0);

        Runnable task = () -> {
            long startTime = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + "started at" + startTime + "with priority " + Thread.currentThread().getPriority());

            for (int i = 0; i < 5_000_000; i++) {
                synchronized (list) {
                    list.add((long) i);
                }

            }
            long totalTime = System.currentTimeMillis() - startTime;
            synchronized (totalPerformanceMillis) {
                totalPerformanceMillis.updateAndGet(v -> v + totalTime);
                System.out.println("end " + Thread.currentThread().getName() + "in " + totalTime + " millis");
            }
        };
        ExecutorService executorService = Executors.newWorkStealingPool(THREAD_POOL_NUMBER);
        IntStream range = IntStream.rangeClosed(1, THREAD_POOL_NUMBER);
        range.parallel().forEach(n -> {
            try {
                Future<?> submit = executorService.submit(task);
                submit.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
        System.out.println("list size " + list.size());
        System.out.println("total thread time " + totalPerformanceMillis + " millis");
    }
}
