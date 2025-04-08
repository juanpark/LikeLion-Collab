package com.person.dao;

import java.util.List;

import com.person.model.Person;

public interface PersonDao {
	String insert_sql="insert into person(name, address, phone) values (?,?,?)";
	String update_sql="update person set address=?, phone=? where name=?";
	String delete_sql="delete from person where name=?";
	String select_sql="select name, address, phone from person";
	
	public int deletePerson(Person p);
	public int insertPerson(Person p);
	public int updatePerson(Person p);
	public List<Person> selectAllPerson();
}
