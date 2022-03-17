package com.godeltech.l3pt2.task3;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FactoryProducer implements Runnable{
    private final Storage storage;

    @Override
    public void run() {
        for (int i = 0; i < 2000000 ; i++) {
            try {
                storage.put((long) i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("end " + Thread.currentThread().getName() + "factory producer");
    }
}
