package com.sec03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/custom")
public class CustomEventController {
	
	@Autowired
	private OrderService orderService;
	
	//@PostMapping("/order")
	@GetMapping("/order") 	//curl http://localhost:8080/custom/order?name=Keyboard&email=juan@email.com 
	public String register(@RequestParam String name, @RequestParam String email) {
		orderService.createOrder(name, email);
		return "Order created : " + name + " : " + email;
	}
}

