package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.student.model.Student;
import static common.JDBCTemplate.*;

public class StudentDaoImpl implements StudentDao {

	@Override
	public int insertStudent(Student s) {
		Connection conn = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = conn.prepareStatement(insert_sql);
			pstm.setString(1, s.getName());
			pstm.setString(2, s.getMajor());
			pstm.setInt(3, s.getGrade());
			
			res = pstm.executeUpdate();
			commit(conn);
			
		} catch (SQLException e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			Close(pstm);
			Close(conn);
		}
		return res;
	}

	@Override
	public int updateStudent(Student s) {
		Connection conn = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = conn.prepareStatement(update_sql);
			pstm.setString(1, s.getMajor());
			pstm.setInt(2, s.getGrade());
			pstm.setString(3, s.getName());
			res = pstm.executeUpdate();
			commit(conn);
			
		} catch (SQLException e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			Close(pstm);
			Close(conn);
		}
		return res;
	}

	@Override
	public int deleteStudent(Student s) {
		Connection conn = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = conn.prepareStatement(delete_sql);
			pstm.setString(1, s.getName());
			res = pstm.executeUpdate();
			commit(conn);
			
		} catch (SQLException e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			Close(pstm);
			Close(conn);
		}
		
		return res;
	}

	@Override
	public List<Student> selectAllStudent() {
		List<Student> all = new ArrayList<>();
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		Student s = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(select_sql);
			
			while(rs.next()) {
				s = new Student();
				s.setStdId(rs.getInt("stdid"));
				s.setName(rs.getString("name"));
				s.setMajor(rs.getString("major"));
				s.setGrade(rs.getInt("grade"));
				all.add(s);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close(rs);
			Close(stmt);
			Close(conn);
		}
		return all;
	}

	@Override
	public Student searchByName(Student s) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Student sFind = null;
		
		try {
			pstmt = conn.prepareStatement(find_sql);
			pstmt.setString(1, s.getName());
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				sFind = new Student();
				sFind.setStdId(rs.getInt("stdid"));
				sFind.setName(rs.getString("name"));
				sFind.setMajor(rs.getString("major"));
				sFind.setGrade(rs.getInt("grade"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close(rs);
			Close(pstmt);
			Close(conn);
		}

		
		return sFind;
	}

	@Override
	public List<Student> getStudentByPage(int page, int size) {
		List<Student> all = new ArrayList<>();
		
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Student s = null;
		
		try {
			pstmt = conn.prepareStatement(page_sql);
			pstmt.setInt(1, size);
			pstmt.setInt(2, (page -1) * size);
			
			rs = pstmt.executeQuery();
			
			while(rs.next() ) {
				s = new Student();
				s.setStdId(rs.getInt("stdid"));
				s.setName(rs.getString("name"));
				s.setMajor(rs.getString("major"));
				s.setGrade(rs.getInt("grade"));
				all.add(s);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close(rs);
			Close(pstmt);
			Close(conn);
		}
		
		return all;
	}

}
