package com.mydb.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmpService {
    private final EmpDao empDao;

    @Autowired
    public EmpService(EmpDao empDao) {
        this.empDao = empDao;
        System.out.println("EmpService's Constructor");
    }

    public List<Emp> getAll() {
        return empDao.findAll();

    }
    
    public void insertEmpwithFail(Emp emp) {
    	empDao.insert(emp);
    	if (true) {
    		throw new RuntimeException("Force Exception!");
    	}
    }
    
    public void insertEmpwithSuccess(Emp emp) {
    	empDao.insert(emp);
  
    }
}
