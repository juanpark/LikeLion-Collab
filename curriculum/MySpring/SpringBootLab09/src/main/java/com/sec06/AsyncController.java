package com.sec06;

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
	private AsyncService asyncService;
	
	//@PostMapping("/register")
	@GetMapping("/hello") 	//http://localhost:8080/async/hello?name=somename
	public String register(@RequestParam String name) {
		asyncService.processAsync(name);
		return "Request Completed (Async process started)";
	}
}

