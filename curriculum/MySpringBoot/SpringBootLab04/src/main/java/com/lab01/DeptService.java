package com.lab01;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptService {
	
	@Autowired
	private DeptRepository deptRepository;
	
	//모든 부서 조회
	public List<Dept> findAll() {
		return deptRepository.findAll();
	}
	
	//부서번호로 부서 상세조회
	public Dept findById(int deptno) {
		return deptRepository.findById(deptno).orElse(null);
	}
}