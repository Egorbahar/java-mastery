package com.godeltech.l3pt2.task2;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Store {
    private int couponNumber;

    public void giveCoupon(final int outstandingCoupon, final User user) {
        couponNumber -= outstandingCoupon;
        user.setCouponNumber(outstandingCoupon);
    }
}
