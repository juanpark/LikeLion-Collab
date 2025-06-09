package com.sec02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/async")
public class AsyncController {
	
	@Autowired
	private AsyncUserService userService;
	
	//@PostMapping("/register")
	@GetMapping("/register") 	//http://localhost:8080/async/register?username=somename
	public String register(@RequestParam String username) {
		userService.registerUser(username);
		return "User registered (async): " + username;
	}
}

