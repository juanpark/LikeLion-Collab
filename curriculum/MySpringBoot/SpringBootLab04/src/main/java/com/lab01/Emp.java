package com.lab01;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {

	@Id
	private int empno;
	private String ename;
	private String job;
	private Integer sal;
	
	@ManyToOne
	@JoinColumn(name = "deptno")
	private Dept dept;
	
}
