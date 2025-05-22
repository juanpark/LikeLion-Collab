package com.workshop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AuditRepository {
    public void save(String msg) {
        System.out.println("Audit 저장: " + msg);
    }
}