package com.lab10.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lab10.domain.Dept;

public interface DeptRepository extends MongoRepository<Dept, Integer> {
	Dept findByDname(String dname);
	//부서명에 특정 키워드가 포함된 부서 목록 조회
	List<Dept> findByDnameContaining(String keyword);
}