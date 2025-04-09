package com.student.service;

import java.util.List;

import com.student.dao.StudentDao;
import com.student.dao.StudentDaoImpl;
import com.student.model.Student;

public class StudentServiceImpl implements StudentService {
	
	private final StudentDao dao = new StudentDaoImpl();
	
	@Override
	public int insertStudent(Student s) {
		// TODO Auto-generated method stub
		return dao.insertStudent(s);
	}

	@Override
	public int updateStudent(Student s) {
		// TODO Auto-generated method stub
		return dao.updateStudent(s);
	}

	@Override
	public int deleteStudent(Student s) {
		// TODO Auto-generated method stub
		return dao.deleteStudent(s);
	}

	@Override
	public List<Student> selectAllStudent() {
		// TODO Auto-generated method stub
		return dao.selectAllStudent();
	}

	@Override
	public Student searchByName(Student s) {
		// TODO Auto-generated method stub
		return dao.searchByName(s);
	}

	@Override
	public List<Student> getStudentByPage(int page, int size) {
		// TODO Auto-generated method stub
		return dao.getStudentByPage(page, size);
	}

}
