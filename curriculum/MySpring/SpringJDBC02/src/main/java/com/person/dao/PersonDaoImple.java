package com.person.dao;

import com.person.model.Person;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

//DB CRUD 
// view -> controller -> dao  [JDBCTemplate] -> db
//view <-  controller <- dao  [JDBCTemplate] <- db
@Repository
public class PersonDaoImple implements PersonDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/// 1.insert
	public int insertPerson(Person p) {
		return jdbcTemplate.update(insert_sql, p.getName(), p.getAddress(), p.getPhone());
	}

	@Override
	public Person searchByName(Person p) {
		return null;
	}

	/// 2.delete
	public int deletePerson(Person p) {
		return jdbcTemplate.update(delete_sql, p.getName());
	}

	/// 3.update
	public int updatePerson(Person p) {
		return jdbcTemplate.update(update_sql, p.getAddress(), p.getPhone(), p.getName());
	}

	private RowMapper<Person> personRowMapper = (rs, rowNum) ->
			new Person(rs.getString("name"),
					rs.getString("address"),
					rs.getString("phone"));

	/// 4.select
	public List<Person> selectAllPerson() {
		return jdbcTemplate.query(select_sql, personRowMapper);
	}

	@Override
	public List<Person> getPersonByPage(int page, int size) {
		return null;
	}
}