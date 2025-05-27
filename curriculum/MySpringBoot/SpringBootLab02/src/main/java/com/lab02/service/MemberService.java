package com.lab02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab02.entity.Member;
import com.lab02.repository.MemberRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	public List<Member> getAllMembers() {
		return memberRepository.findAll();
	}
	
	public Member getMemberById(Long id) {
		return memberRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Member notfound"));
	}
	
	public Member saveMember(Member member) {
		return memberRepository.saveAndFlush(member);
	}
	
	public Member updateMember(Long id, Member member) {
		Member existing = getMemberById(id);
		existing.setName(member.getName());
		existing.setEmail(member.getEmail());
		return memberRepository.save(existing); 
	}
	
	public void deleteMember(Long id) {
		memberRepository.deleteById(id);
	}
}
