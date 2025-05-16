package com.person.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.person.model.Person;
import static common.JDBCTemplate.*;

// DB CRUD
// view -> controller -> dao [JDBCTemplate_BAK] -> db
// view <- controller <- dao [JDBCTemplate_BAK] <- db
public class PersonDaoImple implements PersonDao {
	
	// 1. Insert
	public int insertPerson(Person p) {
		Connection conn = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = conn.prepareStatement(insert_sql); // 쿼리 준비
			// 데이터 바인딩
			pstm.setString(1, p.getName());
			pstm.setString(2, p.getAddress());
			pstm.setString(3, p.getPhone());
			
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
	
	// 2. delete
	public int deletePerson(Person p) {
		Connection conn = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = conn.prepareStatement(delete_sql); // 쿼리 준비
			// 데이터 바인딩
			pstm.setString(1, p.getName());
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
	
	// 3. update
	public int updatePerson(Person p) {
		Connection conn = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = conn.prepareStatement(update_sql); // 쿼리 준비
			// 데이터 바인딩		
			pstm.setString(1, p.getAddress());
			pstm.setString(2, p.getPhone());
			pstm.setString(3, p.getName());
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
	
	// 4. select
	public List<Person> selectAllPerson() {
		/*
		 *  모든 select 결과를 rs객체의 next()로 한줄씩 읽어서 각각의 속성을 person 클래스로 담아서 List<> 객체로 add();
		 */
		List<Person> all = new ArrayList<>(); // 전체 레코드를 Person으로 담아서 리턴 
		Connection conn = getConnection();	// 연결
		Statement stmt = null;	// 명령
		ResultSet rs = null;	// 명령 실행 결과 select를 참조할 객체 선언
		Person person = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(select_sql);
			
			while(rs.next()) {	// raw data가 있으면 한 줄씩 읽어서 리턴 해줘
				// case 1: 매개인자 생성자로 값을 전달 후 add
				/*
				all.add(new Person(
						rs.getString("name"),		// (1)
						rs.getString("address"),	// (2)
						rs.getString("phone")		// (3)
				));	// 리턴한 row의 각 속성들을 person에 담아서 List<Person>에 add한다.*/
				
				// case 2: 기본 생성자 객체 생성 후 setter로 값 전달 후 add
				person = new Person();
				person.setName(rs.getString("name"));
				person.setAddress(rs.getString("address"));
				person.setPhone(rs.getString("phone"));
				all.add(person);
			}
			
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			Close(rs);
			Close(stmt);
			Close(conn);
		}
		
		return all;
	}

	@Override
	public Person seachByName(Person p) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Person person = null;
		
		try {
			pstmt = conn.prepareStatement(find_sql); // 쿼리 준비
			pstmt.setString(1, p.getName()); //데이터 바인딩 
			
			rs = pstmt.executeQuery(); // 실행
			
			while (rs.next()) {
				person = new Person();
				person.setName(rs.getString("name"));
				person.setAddress(rs.getString("address"));
				person.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			Close(rs);
			Close(pstmt);
			Close(conn);	
		}
		return person;
	}

	@Override
	public List<Person> getPersonByPage(int page, int size) {
		List<Person> all = new ArrayList<>();
		
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Person person = null;
		
		try {
			pstmt = conn.prepareStatement(page_sql); // 쿼리 준비
			pstmt.setInt(1, size); //데이터 바인딩 
			pstmt.setInt(2, (page - 1) * size);
			
			rs = pstmt.executeQuery(); // 실행
			
			while (rs.next()) {
				person = new Person();
				person.setName(rs.getString("name"));
				person.setAddress(rs.getString("address"));
				person.setPhone(rs.getString("phone"));
				all.add(person);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			Close(rs);
			Close(pstmt);
			Close(conn);	
		}
		return all;
	}
}

