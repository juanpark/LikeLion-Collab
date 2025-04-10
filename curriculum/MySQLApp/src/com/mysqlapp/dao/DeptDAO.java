package com.mysqlapp.dao;

import java.util.List;
import com.mysqlapp.model.Dept;

public interface DeptDAO {
    String INSERT_SQL = "INSERT INTO dept(dname, loc) VALUES (?, ?)";
    String UPDATE_SQL = "UPDATE dept SET dname=?, loc=? WHERE deptno=?";
    String DELETE_SQL = "DELETE FROM dept WHERE deptno=?";
    String SELECT_ALL_SQL = "SELECT * FROM dept";
    String SELECT_BY_DEPTNO = "SELECT * FROM dept WHERE deptno=?";

    int insert(Dept d);
    int update(Dept d);
    int delete(int deptno);
    Dept findByDeptno(int deptno);
    List<Dept> findAll();
}
