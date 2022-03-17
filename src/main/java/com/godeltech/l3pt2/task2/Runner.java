package com.godeltech.l3pt2.task2;

public class Runner {
    public static void main(String[] args) {
        Store store = new Store(100);
        CouponDispenser.takeCoupon(store, 4);
    }
}
