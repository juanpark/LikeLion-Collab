package com.test03;

public class MemoryMemberRepository implements MemberRepository {
    @Override
    public String findMemberById(int id) {
        return "홍길동";
    }
}
