package com.sec01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sync")
public class SyncController {
	
	@Autowired
	private SyncUserService userService;
	
	//@PostMapping("/register")
	@GetMapping("/register") 	//http://localhost:8080/sync/register?username=lee 
	public String register(@RequestParam String username) {
		userService.registerUser(username);
		return "User registered (sync): " + username;
	}
}

