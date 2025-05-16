package com.person.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.person.model.Person;
import static common.JDBCTemplate.*;

import java.util.List;

// DB CRUD
// view -> controller -> dao [JDBCTemplate_BAK] -> db
// view <- controller <- dao [JDBCTemplate_BAK] <- db
@Repository
public class PersonDaoImple implements PersonDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/* @Autowired가 대체하는 보일러플레이트 
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	*/
	
	// 1. Insert
	public int insertPerson(Person p) {
	
		return 0;
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

	@Override
	public Person seachByName(Person p) {
	
		return null;
	}

	@Override
	public List<Person> getPersonByPage(int page, int size) {
	
		return null;
	}
}

