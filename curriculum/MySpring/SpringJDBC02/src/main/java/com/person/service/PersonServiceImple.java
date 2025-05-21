package com.person.service;

import java.util.List;

import com.person.dao.PersonDao;
import com.person.dao.PersonDaoImple;
import com.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImple implements PersonService {

	@Autowired
	private PersonDao dao;
	
	@Override
	public List<Person> selectAllPerson() {
		// TODO Auto-generated method stub
		return dao.selectAllPerson();
	}

	@Override
	public int insertPerson(Person p) {
		// TODO Auto-generated method stub
		return dao.insertPerson(p);
	}

	@Override
	public int deletePerson(Person p) {
		// TODO Auto-generated method stub
		return dao.deletePerson(p);	
	}

	@Override
	public int updatePerson(Person p) {
		// TODO Auto-generated method stub
		return dao.updatePerson(p);
	}

	@Override
	public Person searchByName(Person p) {
		// TODO Auto-generated method stub
		return dao.searchByName(p);	}

	@Override
	public List<Person> getPersonByPage(int page, int size) {
		// TODO Auto-generated method stub
		return dao.getPersonByPage(page, size);
	}
	
	
}
