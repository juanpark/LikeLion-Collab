package com.workshop.dao;

import org.springframework.stereotype.Repository;

import com.workshop.vo.Member;

@Repository
public class MemberRepository {
    public void save(Member m) {
        System.out.println("저장됨: " + m.getName());
    }
}