package com.person.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.person.model.Person;
import static common.JDBCTemplate.*;

// DB CRUD
// view -> controller -> dao [JDBCTemplate] -> db
// view <- controller <- dao [JDBCTemplate] <- db
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
		return 0;
	}
	
	// 3. update
	public int updatePerson(Person p) {
		return 0;
	}
	
	// 4. select
	public List<Person> selectAllPerson() {
		return null;
	}
}
