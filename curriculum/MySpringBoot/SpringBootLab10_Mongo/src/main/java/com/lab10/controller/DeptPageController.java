package com.lab10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lab10.domain.Dept;
import com.lab10.domain.Emp;
import com.lab10.service.DeptService;
import com.lab10.service.EmpService;

@Controller
public class DeptPageController {
	@Autowired 
	private DeptService deptService;
	
	@Autowired
	private EmpService empService;
	
	@GetMapping("/dept/detail/{deptno}")
	public String showDetail(@PathVariable int deptno, Model model) {
		Dept dept = deptService.findByDeptno(deptno);
		List<Emp> empList = empService.findByDeptno(deptno);
		
		model.addAttribute("dept", dept);
		model.addAttribute("emplist", empList);
		
		return "deptDetail";
		
	}

}
