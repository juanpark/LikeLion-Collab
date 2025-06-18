package com.lab10.controller;

import com.lab10.domain.Emp;
import com.lab10.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {

    private final EmpService empService;

    public EmpController(EmpService empService) {
		this.empService = empService;
	}
    
    // 1. 등록 및 수정 
	@PostMapping
    public ResponseEntity<String> save(@RequestBody Emp emp) {
        empService.save(emp);
        return ResponseEntity.ok("saved");
    }

	// 2. 전체 조회 
    @GetMapping
    public List<Emp> findAll() {
        return empService.findAll();
    }

    // 3. 단일 조회 
    @GetMapping("/{empno}")
    public Emp findByEmpno(@PathVariable int empno) {
        return empService.findByEmpno(empno);
    }

    // 4. 삭제 
    @DeleteMapping("/{empno}")
    public ResponseEntity<String> delete(@PathVariable int empno) {
        empService.delete(empno);
        return ResponseEntity.ok("deleted");
    }

    // 5.이름 키워드 검색 
    @GetMapping("/search")
    public List<Emp> searchByName(@RequestParam String keyword) {
        return empService.searchByName(keyword);
    }
    
    // 6. 급여 조건 검색 
    @GetMapping("/sal")
    public List<Emp> findBySalaryAbove(@RequestParam("min") int minSalary) {
        return empService.findBySalaryAbove(minSalary);
    }

    // 7. 부서번호로 사원 검색 
    @GetMapping("/dept/{deptno}")
    public List<Emp> findByDeptno(@PathVariable int deptno) {
        return empService.findByDeptno(deptno);
    }
}