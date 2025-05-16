package com.mysqlapp.service;

import com.mysqlapp.model.Emp;
import com.mysqlapp.model.EmpDeptDTO;
import com.mysqlapp.model.EmpSalGradeDTO;

import java.util.List;

public interface EmpService {
    int insertEmp(Emp emp);
    int updateEmp(Emp emp);
    int deleteEmp(int empno);
    Emp getEmpByEmpno(int empno);
    List<Emp> getAllEmps();
    List<EmpDeptDTO> getEmpWithDept();
    List<EmpSalGradeDTO> getEmpWithSalgrade();
}
