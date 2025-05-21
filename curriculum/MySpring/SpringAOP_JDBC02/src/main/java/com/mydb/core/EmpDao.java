package com.mydb.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDao {

    private final JdbcTemplate jdbcTemplate;

   
    // 생성자 주입 
    @Autowired
    public EmpDao(JdbcTemplate jdbcTemplate) {
    	this.jdbcTemplate = jdbcTemplate;
    	System.out.println("EmpDao's Constructor");
    }

    //1. SELECT ALL
    public List<Emp> findAll() {
    	String sql = "SELECT * FROM EMP";
    	return jdbcTemplate.query(sql, new EmpRowMapper());
        
    }
  
    // 내부 RowMapper 클래스
    private static class EmpRowMapper implements RowMapper<Emp> {

		@Override
		public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Emp(rs.getInt("empno"), rs.getString("ename"), rs.getString("job"), rs.getInt("deptno"));
		}
      
    }
    
    //2. INSERT Data
    public void insert(Emp emp) {
    	String sql = "INSERT INTO emp(empno, ename, job, deptno) values(?,?,?,?)";
    	jdbcTemplate.update(sql, emp.getEmpno(), emp.getEname(), emp.getJob(), emp.getDeptno());
    	
    }
}
