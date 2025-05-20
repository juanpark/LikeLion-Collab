package com.test01;

public class FixDiscountPolicy implements DiscountPolicy {
    @Override
    public int getDiscountAmount(int price) {
        return 1000;
    }
}
