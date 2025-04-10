package com.mysqlapp.service;

import com.mysqlapp.model.Dept;
import java.util.List;

public interface DeptService {
    int insertDept(Dept dept);
    int updateDept(Dept dept);
    int deleteDept(int deptno);
    Dept findDeptByNo(int deptno);
    List<Dept> getAllDepts();
}
