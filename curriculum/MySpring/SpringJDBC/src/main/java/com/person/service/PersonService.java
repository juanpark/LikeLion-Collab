package com.person.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.person.model.Person;

// view -> Controller -> Model (Service(biz), Dao) -> DB
@Service
public interface PersonService {
	// biz
	// Dao
	List<Person> selectAllPerson();
	int insertPerson(Person p);
	int deletePerson(Person p);
	int updatePerson(Person p);
	Person searchByName(Person p);
	List<Person> getPersonByPage(int page, int size);
}
