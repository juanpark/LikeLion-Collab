package com.mysqlapp.service;

import com.mysqlapp.dao.DeptDAO;
import com.mysqlapp.dao.DeptDAOImpl;
import com.mysqlapp.model.Dept;

import java.util.List;

public class DeptServiceImpl implements DeptService {
    private final DeptDAO dao = new DeptDAOImpl();

    @Override
    public int insertDept(Dept dept) {
        return dao.insert(dept);
    }

    @Override
    public int updateDept(Dept dept) {
        return dao.update(dept);
    }

    @Override
    public int deleteDept(int deptno) {
        return dao.delete(deptno);
    }

    @Override
    public Dept findDeptByNo(int deptno) {
        return dao.findByDeptno(deptno);
    }

    @Override
    public List<Dept> getAllDepts() {
        return dao.findAll();
    }
}
