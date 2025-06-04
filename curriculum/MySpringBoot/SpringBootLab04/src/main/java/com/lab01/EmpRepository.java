package com.lab01;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer> {
	//추가 코드
	//			findBy Dept Deptno 
	// JPQL -> select e from emp e where e.dept.deptno = :deptno 
	List<Emp> findByDeptDeptno(int deptno);
}