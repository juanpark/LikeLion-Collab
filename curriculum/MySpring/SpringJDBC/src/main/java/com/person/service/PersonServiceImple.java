package com.person.service;

import java.util.List;

import com.person.dao.PersonDao;
import com.person.dao.PersonDaoImple;
import com.person.model.Person;

// biz, dao 관리 및 구현
// 현재 Person 테이블의 insert 값은 계산형 데이터 또는 로직이 없어서 dao만 호출 되어 controller, db 연동된다.
// controller -> service(bix X, dao O) -> db
public class PersonServiceImple implements PersonService {

	private final PersonDao dao = new PersonDaoImple();
	
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
		return dao.seachByName(p);
	}

	@Override
	public List<Person> getPersonByPage(int page, int size) {
		// TODO Auto-generated method stub
		return dao.getPersonByPage(page, size);
	}



}
