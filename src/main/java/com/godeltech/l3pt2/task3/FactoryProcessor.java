package com.godeltech.l3pt2.task3;

import lombok.AllArgsConstructor;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

@AllArgsConstructor
public class FactoryProcessor implements Runnable {
    private final Storage storage;
    private final static AtomicLong totalProcessedDetail = new AtomicLong(0);
    private final static AtomicReference<Long> totalPerformanceMillis = new AtomicReference<>((long) 0);

    public void run() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 2000000; i++) {
            synchronized (totalProcessedDetail) {
                totalProcessedDetail.updateAndGet(v -> v + storage.get());
            }
        }
        long totalTime = System.currentTimeMillis() - startTime;
        synchronized (totalPerformanceMillis) {
            totalPerformanceMillis.updateAndGet(v -> v + totalTime);
            System.out.println("end " + Thread.currentThread().getName() + "factory processor");
        }
    }

    public static AtomicLong getTotalProcessedDetail() {
        return totalProcessedDetail;
    }

    public static AtomicReference<Long> getTotalPerformanceMillis() {
        return totalPerformanceMillis;
    }
}
