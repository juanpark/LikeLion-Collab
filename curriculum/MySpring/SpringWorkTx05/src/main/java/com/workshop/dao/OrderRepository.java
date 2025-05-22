package com.workshop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    public void save(String order) {
        System.out.println("주문 저장: " + order);
    }
}