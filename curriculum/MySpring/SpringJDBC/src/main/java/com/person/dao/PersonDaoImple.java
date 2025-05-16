package com.person.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
	
	// 1. Insert : update(String sql, Object... args)
	public int insertPerson(Person p) {
		return jdbcTemplate.update(insert_sql, p.getName(), p.getAddress(), p.getPhone());
	}
	
	// 2. delete : update(String sql, Object... args)
	public int deletePerson(Person p) {
		return jdbcTemplate.update(delete_sql, p.getName());
	}
	
	// 3. update : update(String sql, Object... args)
	public int updatePerson(Person p) {
		return jdbcTemplate.update(update_sql, p.getAddress(), p.getPhone(), p.getName());
	}
	
	private RowMapper<Person> personRowMapper = (rs, rowNum) -> 
		new Person(	rs.getString("name"),
					rs.getString("address"),
					rs.getString("phone"));
	
	// 4. select All : query(String sql, RowMapper<T> rowMapper)
	public List<Person> selectAllPerson() {
		return jdbcTemplate.query(select_sql, personRowMapper);
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

