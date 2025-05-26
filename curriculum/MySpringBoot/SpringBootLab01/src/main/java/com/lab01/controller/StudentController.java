package com.lab01.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab01.entity.Student;
import com.lab01.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	private final StudentService studentService;
	
	public StudentController(StudentService studentService) {
        this.studentService = studentService;
	}
	
	
	@GetMapping
    public CollectionModel<EntityModel<Student>> getAllStudents() {
        List<Student> students = studentService.findAll();

 // 추가 코드
        List<EntityModel<Student>> studentModels = students.stream().map(
                student -> EntityModel.of(student,
                WebMvcLinkBuilder
                        .linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getStudentById(student.getId()))
                        .withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getAllStudents())
                        .withRel("all-students")))
                .collect(Collectors.toList());

        return CollectionModel.of(studentModels, WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getAllStudents()).withSelfRel());
    }

	@PostMapping
	Student createStudent(@RequestBody Student student) {
		return studentService.save(student);
	}
	
	//GET /students/{id}
	@GetMapping("/{id}")
	public EntityModel<Student> getStudentById(@PathVariable Long id) {
		Student student = studentService.findById(id);
		
		EntityModel<Student> resource = EntityModel.of(student);
		
		resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getStudentById(id))
				.withSelfRel());
		
		resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getAllStudents())
				.withRel("all-students"));
		
		return resource;
	}
	
	//PUT /students/{id}
	@PutMapping("/{id}")
	Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
		Student res = studentService.findById(id);
		res.setGrade(student.getGrade());
		res.setName(student.getName());
		return studentService.save(res);
	}
	
	//DELETE /students/{id}
	@DeleteMapping("/{id}")
	void deleteStudent(@PathVariable Long id) {
		studentService.delete(id);
	}
}
