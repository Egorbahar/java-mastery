package com.godeltech.l3pt2.task2;

import lombok.Getter;

@Getter
public class User {
    private int couponNumber;

    public void takeCoupon(int takingCoupon, Store store) {
        store.giveCoupon(takingCoupon);
        this.couponNumber += takingCoupon;
    }
}
