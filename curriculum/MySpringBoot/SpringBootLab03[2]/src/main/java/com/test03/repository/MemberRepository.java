package com.test03.repository;

import com.test03.entity.Member;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

  //추가 메소드
  //Optional : 리턴값이 null일 경우 -> nullpointException을 방지함
  Optional<Member> findByUsername(String username);

  //전체 회원 중 ID 내림차순 5명 조회
  List<Member> findTop5ByOrderByIdDesc();

}
