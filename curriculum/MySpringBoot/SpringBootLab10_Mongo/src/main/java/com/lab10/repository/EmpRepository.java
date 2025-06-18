package com.lab10.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lab10.domain.Emp;

public interface EmpRepository extends MongoRepository<Emp, Integer> {
	List<Emp> findByEnameContaining(String keyword);
	List<Emp> findBySalGreaterThanEqual(Integer sal);
	List<Emp> findByDept(Integer deptno);
}