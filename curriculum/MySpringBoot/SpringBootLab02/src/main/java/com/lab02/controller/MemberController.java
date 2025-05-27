package com.lab02.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab02.entity.Member;
import com.lab02.service.MemberService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/members")
public class MemberController {

    private final MemberService memberService;

	private Member member;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping
	public List<Member> getAllMembers() {
		return memberService.getAllMembers();
	}
	
	@GetMapping("/{id}")
	public Member getMemberById(@PathVariable Long id) {
		return memberService.getMemberById(id);
	}
	
	@PostMapping
	public Member saveMember(@Valid @RequestBody Member member) {
		return memberService.saveMember(member);
	}
	
	@PutMapping("/{id}")
	public Member updateMember(@PathVariable Long id, @Valid @RequestBody Member member) {
		return memberService.updateMember(id, member);
	}
	
	@DeleteMapping("/{id}")
	public void deleteMember(@PathVariable Long id) {
		memberService.deleteMember(id);
		
	}
	
}
