package com.test03.controller;

import com.test03.entity.Member;
import com.test03.service.MemberService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OAuth2LoginController {
  @Autowired
  private MemberService memberService;
  public OAuth2LoginController(MemberService memberService) {
    this.memberService = memberService;
  }
  //인증한 토큰값으로 실행할 수 있도록 @AuthenticationPrincipal 이용
  // 인증된 사용자를 서비스에 전달할 수 있음
  @GetMapping("/home")
  public String home(@AuthenticationPrincipal OAuth2User
      oauth2User, Model model) {
    memberService.saveOrUpdateMember(oauth2User);
    List<Member> members = memberService.getAllMembers();
    model.addAttribute("members", members);
    return "home";
  }
}