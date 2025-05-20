package com.test02;

import com.test01.DiscountPolicy;

public class RateDiscountPolicy implements DiscountPolicy {
    @Override
    public int getDiscountAmount(int price) {
        return price * 10 / 100;
    }
}
