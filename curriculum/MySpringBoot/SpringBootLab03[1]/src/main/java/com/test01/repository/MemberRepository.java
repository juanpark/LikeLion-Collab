package com.test01.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.test01.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	//추가 메서드
	//Optional : return value may be null or not null -> NullPointException prevention
	Optional<Member> findByUsername(String username);
	
	List<Member> findTop5ByOrderByIdDesc();
}
