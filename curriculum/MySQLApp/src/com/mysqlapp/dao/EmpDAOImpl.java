package com.mysqlapp.dao;

import com.mysqlapp.model.Emp;
import com.mysqlapp.model.EmpDeptDTO;

import java.sql.*;
import java.util.*;

import static common.JDBCTemplate.*;

//record 기반
public class EmpDAOImpl implements EmpDAO {

	@Override
	public int insert(Emp e) {
		Connection conn = getConnection();
		int result = 0;
		try (PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL)) {
			pstmt.setString(1, e.ename());
			pstmt.setString(2, e.job());
			pstmt.setInt(3, e.mgr());
			pstmt.setDate(4, new java.sql.Date(e.hiredate().getTime()));
			pstmt.setDouble(5, e.sal());
			pstmt.setDouble(6, e.comm());
			pstmt.setInt(7, e.deptno());
			result = pstmt.executeUpdate();
			if (result > 0)
				commit(conn);
			else
				rollback(conn);
		} catch (Exception ex) {
			rollback(conn);
			ex.printStackTrace();
		} finally {
			close(conn);
		}
		return result;
	}

	@Override
	public int update(Emp e) {
		Connection conn = getConnection();
		int result = 0;
		try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_SQL)) {
			pstmt.setString(1, e.ename());
			pstmt.setString(2, e.job());
			pstmt.setDouble(3, e.sal());
			pstmt.setDouble(4, e.comm());
			pstmt.setInt(5, e.empno());
			result = pstmt.executeUpdate();
			if (result > 0)
				commit(conn);
			else
				rollback(conn);
		} catch (Exception ex) {
			rollback(conn);
			ex.printStackTrace();
		} finally {
			close(conn);
		}
		return result;
	}

	@Override
	public int delete(int empno) {
		Connection conn = getConnection();
		int result = 0;
		try (PreparedStatement pstmt = conn.prepareStatement(DELETE_SQL)) {
			pstmt.setInt(1, empno);
			result = pstmt.executeUpdate();
			if (result > 0)
				commit(conn);
			else
				rollback(conn);
		} catch (Exception ex) {
			rollback(conn);
			ex.printStackTrace();
		} finally {
			close(conn);
		}
		return result;
	}

	@Override
	public Emp findByEmpno(int empno) {
		Connection conn = getConnection();
		Emp e = null;
		try (PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_EMPNO)) {
			pstmt.setInt(1, empno);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				e = new Emp(rs.getInt("empno"), rs.getString("ename"), rs.getString("job"), rs.getInt("mgr"),
						rs.getDate("hiredate"), rs.getDouble("sal"), rs.getDouble("comm"), rs.getInt("deptno"));
			}
			close(rs);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(conn);
		}
		return e;
	}

	@Override
	public List<Emp> findAll() {
		List<Emp> list = new ArrayList<>();
		Connection conn = getConnection();
		try (PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_SQL); ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				Emp e = new Emp(rs.getInt("empno"), rs.getString("ename"), rs.getString("job"), rs.getInt("mgr"),
						rs.getDate("hiredate"), rs.getDouble("sal"), rs.getDouble("comm"), rs.getInt("deptno"));
				list.add(e);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(conn);
		}
		return list;
	}

	@Override
	public List<EmpDeptDTO> findEmpWithDept() {
		List<EmpDeptDTO> list = new ArrayList<>();
		Connection conn = getConnection();

		try (PreparedStatement pstmt = conn.prepareStatement(join); ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				EmpDeptDTO dto = new EmpDeptDTO(rs.getString("ename"), rs.getInt("deptno"), rs.getString("dname"),
						rs.getString("loc"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return list;
	}

}
