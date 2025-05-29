package com.test01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.test01.entity.Member;
import com.test01.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute("member", new Member());
		return "register";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute Member member) {
		memberService.register(member);
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}
	

	@GetMapping("/home")
	public String home(Model model) {
		List<Member> members = memberService.getTop5Members();
		model.addAttribute("members", members);
		return "home";
	}
	
	public List<Member> getAllMembers() {

		return null;
	}
	/*
	@GetMapping("/home")
	public String home(Model model) {
	    List<Member> members = memberService.getAllMembers();
	    model.addAttribute("members", members);
	    return "home";
	}*/
}
