package com.example.chatserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // @RestController와는 별도!
public class PageController {

    @GetMapping("/")
    public String landing(){
        return "landing";   // 로그인 화면
    }

    @GetMapping("/chat")
    public String chat() {
        return "chat"; //.html 필요없음...
    }
}
