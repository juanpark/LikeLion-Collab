package com.lab01;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor @AllArgsConstructor
public @Data class Dept {
	@Id
	private int deptno;
	private String dname;
	private String loc;
	
	@OneToMany(mappedBy = "dept")
	private List<Emp> emps;
}
