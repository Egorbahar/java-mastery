package com.godeltech.l3pt2.task3;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

@Getter
public class Storage {
    private final static int DEFAULT_STORAGE_CAPACITY = 1000;
    private final List<Long> detailStorage = new LinkedList<>();

    public synchronized int get() {
        while (detailStorage.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        detailStorage.remove(detailStorage.size() - 1);
        notify();
        return 1;
    }

    public synchronized void put(Long detail) throws InterruptedException {
        while (detailStorage.size() >= DEFAULT_STORAGE_CAPACITY) {
            wait();
        }
        detailStorage.add(detail);
        notify();
    }
}
