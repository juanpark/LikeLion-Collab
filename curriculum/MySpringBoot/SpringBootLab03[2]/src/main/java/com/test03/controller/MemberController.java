package com.test03.controller;

import com.test03.entity.Member;
import com.test03.service.MemberService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
  private final MemberService memberService;

  @GetMapping("/index")
  public String index(){
    return "index";
  }

  @GetMapping("/register")
  public String registerForm(Model model){
    model.addAttribute("member", new Member());
    return "register";
  }

  @PostMapping("/register")
  public String register(@ModelAttribute Member member) {
    memberService.register(member);
    return "redirect:/login";
  }

//  @GetMapping("/login")
//  public String loginForm(){
//    return "login";
//  }

//  @GetMapping("/home")
//  public String home(Model model){
//    List<Member> members = memberService.getAllMembers();
//    model.addAttribute("members", members);
//    return "home";
//  }

//  @GetMapping("/members")
//  public List<Member> getAllMembers(){
//    return memberService.getAllMembers();
//  }
}
