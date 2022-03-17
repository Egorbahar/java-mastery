package com.godeltech.l3pt2.task3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class FactoryRunner {
    public static void main(String[] args) {
       final Storage storage = new Storage();
       final ExecutorService executorService = Executors.newWorkStealingPool(8);
        IntStream range = IntStream.rangeClosed(1, 4);
        range.parallel().forEach(n -> {
                Future<?> submitFactoryProducer = executorService.submit(new Thread(new FactoryProducer(storage)));
                Future<?> submitFactoryHandler = executorService.submit(new Thread(new FactoryProcessor(storage)));
                try {
                    submitFactoryProducer.get();
                    submitFactoryHandler.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
        });
        executorService.shutdown();
        System.out.println("total thread time " + FactoryProcessor.getTotalPerformanceMillis() + " millis");
        System.out.println("Number of parts processed : " + FactoryProcessor.getTotalProcessedDetail());
    }
}
