package com.lab10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab10.domain.Dept;
import com.lab10.repository.DeptRepository;

@Service
public class DeptService {

    private final DeptRepository deptRepository;

    public DeptService(DeptRepository deptRepository) {
		this.deptRepository = deptRepository;
	}

	// 1. 부서 저장 (등록 또는 수정)
    public void save(Dept dept) {
        deptRepository.save(dept);
    }

    // 2. 모든 부서 목록 조
    public List<Dept> findAll() {
        return deptRepository.findAll();
    }

    // 3. 부서번호로 단일 부서 조회 
    public Dept findByDeptno(int deptno) {
        return deptRepository.findById(deptno).orElse(null);
    }

    // 4. 부서명에 특정 키워드가 포함된 부서 목록 조
    public List<Dept> findByDnameContaining(String keyword) {
        return deptRepository.findByDnameContaining(keyword);
    }

    // 5. 부서명으로 단일 부서 조회 
    public Dept findByDname(String dname) {
        return deptRepository.findByDname(dname);
    }
}