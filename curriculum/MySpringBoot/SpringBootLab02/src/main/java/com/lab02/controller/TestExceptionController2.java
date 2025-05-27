
package com.lab02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import jakarta.persistence.EntityNotFoundException;

@Controller
public class TestExceptionController2 {

	// (1) 유효성 검증 실패 처리

// (2) 엔티티를 찾지 못했을 때 처리 	
	@GetMapping("/notfound")
	public String testEntityNotFound() {
		throw new EntityNotFoundException("엔티티를 찾을 수 없습니다!");
	}

	// (3) 그 외의 예외 처리
	@GetMapping("/other")
	public String testException() throws Exception {
		throw new Exception(" 기타등등 예외야!!");
	}

	
	
}
