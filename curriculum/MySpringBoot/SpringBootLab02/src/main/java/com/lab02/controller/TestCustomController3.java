
package com.lab02.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;


@Controller
public class TestCustomController3 implements ErrorController{

	@RequestMapping("/error")
	public String testEntityNotFound(HttpServletRequest request, Model model) {
	    Object status  = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	    Object msr  = request.getAttribute(RequestDispatcher.ERROR_MESSAGE); 
	 	model.addAttribute("status", status);
	 	model.addAttribute("msr", msr);		
		return "custom-error"; 
	}
	
	
	
}
