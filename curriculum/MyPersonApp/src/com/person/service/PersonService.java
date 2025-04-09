package com.person.service;

import java.util.List;

import com.person.model.Person;

// view -> Controller -> Model (Service(biz), Dao) -> DB
public interface PersonService {
	// biz
	// Dao
	List<Person> selectAllPerson();
	int insertPerson(Person p);
}
