package com.mysqlapp.dao;

import java.util.List;
import com.mysqlapp.model.Emp;
import com.mysqlapp.model.EmpDeptDTO;
import com.mysqlapp.model.EmpSalGradeDTO;

public interface EmpDAO {
    String INSERT_SQL = "INSERT INTO emp(ename, job, mgr, hiredate, sal, comm, deptno) VALUES (?, ?, ?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE emp SET ename=?, job=?, sal=?, comm=? WHERE empno=?";
    String DELETE_SQL = "DELETE FROM emp WHERE empno=?";
    String SELECT_ALL_SQL = "SELECT * FROM emp";
    String SELECT_BY_EMPNO = "SELECT * FROM emp WHERE empno=?";
    
    ////join 코드  
    ///
    String join =" SELECT e.ename, d.deptno, d.dname, d.loc\n"
    		+ "        FROM emp e \n"
    		+ "        JOIN dept d ON e.deptno = d.deptno ";
    
    String Eqjoin = "SELECT ENAME, SAL, GRADE as 등급결과 \n"
    		+ "FROM EMP JOIN SALGRADE ON (SAL>=LOSAL AND SAL <= HISAL)";
    

    int insert(Emp e);
    int update(Emp e);
    int delete(int empno);
    Emp findByEmpno(int empno);
    List<Emp> findAll();
    List<EmpDeptDTO> findEmpWithDept(); //join 코드 
    List<EmpSalGradeDTO> getEmpWithSalgrade();
}
