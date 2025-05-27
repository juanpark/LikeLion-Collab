package com.lab02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab02.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
	
}
