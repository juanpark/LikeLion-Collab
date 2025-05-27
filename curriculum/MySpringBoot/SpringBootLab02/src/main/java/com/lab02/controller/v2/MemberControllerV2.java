package com.lab02.controller.v2;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab02.entity.Member;
import com.lab02.entity.MemberDto;
import com.lab02.service.MemberService;

@RestController
@RequestMapping("/v2/members")
public class MemberControllerV2 {
	
	private final MemberService memberService;
	
	public MemberControllerV2(MemberService memberService) {
	this.memberService = memberService;
	}
	
	@GetMapping
	public List<MemberDto> getAllMembers() {
		// V2 에서는 DTO 로 응답
		List<Member> members = memberService.getAllMembers();
		return members.stream()
		.map(member -> new MemberDto(member.getId(),
		member.getName()))
		.collect(Collectors.toList());
	}
	// 그 외 메서드는 V1 과 동일하게 구현 (예제 간단화)

}
