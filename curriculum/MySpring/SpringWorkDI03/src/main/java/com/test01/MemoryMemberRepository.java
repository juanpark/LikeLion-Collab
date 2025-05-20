package com.test01;

public class MemoryMemberRepository implements MemberRepository {
    @Override
    public String findMemberById(int id) {
        return "홍길동";
    }
}
