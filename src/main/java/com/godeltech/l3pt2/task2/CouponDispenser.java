package com.godeltech.l3pt2.task2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class CouponDispenser {
    private static final Map<User, Integer> userMap = new HashMap<>();

    public static void takeCoupon(final Store store, final int userNumber) {
        Runnable takeCouponTask = () -> {
            int coupon = (int) (Math.random() * 10);
            User user = new User();
            store.giveCoupon(coupon, user);
            userMap.put(user, user.getCouponNumber());
            System.out.println(Thread.currentThread().getName());
        };
        ExecutorService executorService = Executors.newFixedThreadPool(userNumber);
        IntStream range = IntStream.rangeClosed(1, userNumber);
        range.parallel().forEach(n -> {
            Future<?> submit = executorService.submit(takeCouponTask);
            try {
                submit.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
        userMap.keySet().forEach(key -> {
            System.out.println("User " + key + " with " + key.getCouponNumber() + " coupons");
        });
        int totalUserCoupon = userMap.values().stream().mapToInt(value -> value).sum();
        System.out.println("Total numbers of coupons in store: " + store.getCouponNumber());
        System.out.println("Total numbers of coupons for all users: " + totalUserCoupon);

    }
}
