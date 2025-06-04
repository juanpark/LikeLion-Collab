package com.test03.service;

import com.test03.entity.Member;
import com.test03.repository.MemberRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;
  private final PasswordEncoder passwordEncoder;

  @Transactional
  public Member register(Member member) {
    // 암호화된 패스워드를 가진 멤버를 insert 하게 됨
    member.setPassword(passwordEncoder.encode(member.getPassword()));
    System.out.println("비밀번호: "+member.getPassword());
    return memberRepository.save(member);
  }

  public List<Member> getAllMembers() {
    return memberRepository.findTop5ByOrderByIdDesc();
  }

  @Transactional
  public void saveOrUpdateMember(OAuth2User oauth2User){
    String email = oauth2User.getAttribute("email");
    String name = oauth2User.getAttribute("name");

    Member member = memberRepository.findByUsername(email)
        .orElse(new Member());

    member.setUsername(email);
    //member.setUsername(name);

    if (member.getPassword() == null) {
      member.setPassword("oauth2user");
    }
    memberRepository.save(member);
    System.out.println("저장된 사용자: " +
        member.getUsername());
  }
}
