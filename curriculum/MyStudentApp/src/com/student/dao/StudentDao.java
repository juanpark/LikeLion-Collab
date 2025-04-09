package com.student.dao;

import java.util.List;

import com.student.model.Student;

public interface StudentDao {
	String insert_sql="INSERT INTO student(name, major, grade) VALUES (?,?,?)";
	String update_sql="UPDATE student SET major=?, grade=? WHERE name=?";
	String delete_sql="DELETE FROM student WHERE name=?";
	String select_sql="SELECT stdid, name, major, grade FROM student";
	String find_sql="SELECT stdid, name, major, grade FROM student WHERE name=?";
	String page_sql="SELECT * FROM student LIMIT ? OFFSET ?";
	
	public int insertStudent(Student s);
	public int updateStudent(Student s);
	public int deleteStudent(Student s);
	public List<Student> selectAllStudent();
	public Student searchByName(Student s);
	public List<Student> getStudentByPage(int page, int size);
}
