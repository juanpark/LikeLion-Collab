package com.test01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test01.entity.Member;
import com.test01.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //1. 생성자 값 주입 명시 2. NotNull처리 @ 선언 시
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private final MemberRepository memberRepository;
	
	@Override //엔티티로 데이터를 추출한 Member의 필드를 User객체에 담아서
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = memberRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다"));
		
		return User.builder()
				.username(member.getUsername())
				.password(member.getPassword())
				.roles(member.getRole().replace("ROLE_", ""))
				.build();
	}
	

}
