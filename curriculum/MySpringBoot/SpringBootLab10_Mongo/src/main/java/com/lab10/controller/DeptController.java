package com.lab10.controller;

import com.lab10.domain.Dept;
import com.lab10.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {

    private final DeptService deptService;

    public DeptController(DeptService deptService) {
		this.deptService = deptService;
	}
    
    // 1. 등록 및 수정 
	@PostMapping
    public void save(@RequestBody Dept dept) {
        deptService.save(dept);
    }

	// 2. 전체 조회 
    @GetMapping
    public List<Dept> findAll() {
        return deptService.findAll();
    }

    // 3. 단일 조회 /dept/10
    @GetMapping("/{deptno}")
    public Dept findByDeptno(@PathVariable int deptno) {
        return deptService.findByDeptno(deptno);
    }

    // 4. 부서명 키워드 검색 /dept/search?keyword=
    @GetMapping("/search")
    public List<Dept> searchByDname(@RequestParam String keyword) {
        return deptService.findByDnameContaining(keyword);
    }
    
    // 5. 지도 마커용 API (위도/경도 포함)
    @GetMapping("/api")
    public List<Dept> findForMap() {
        return deptService.findAll();
    }


}