package com.mysqlapp.service;

import com.mysqlapp.dao.EmpDAO;
import com.mysqlapp.dao.EmpDAOImpl;
import com.mysqlapp.model.Emp;
import com.mysqlapp.model.EmpDeptDTO;
import com.mysqlapp.model.EmpSalGradeDTO;

import java.util.List;

public class EmpServiceImpl implements EmpService {
    private final EmpDAO dao = new EmpDAOImpl();

    @Override
    public int insertEmp(Emp emp) {
        return dao.insert(emp);
    }

    @Override
    public int updateEmp(Emp emp) {
        return dao.update(emp);
    }

    @Override
    public int deleteEmp(int empno) {
        return dao.delete(empno);
    }

    @Override
    public Emp getEmpByEmpno(int empno) {
        return dao.findByEmpno(empno);
    }

    @Override
    public List<Emp> getAllEmps() {
        return dao.findAll();
    }

    @Override
    public List<EmpDeptDTO> getEmpWithDept() {
        return dao.findEmpWithDept();
    }

	@Override
	public List<EmpSalGradeDTO> getEmpWithSalgrade() {
		// TODO Auto-generated method stub
		return dao.getEmpWithSalgrade();
	}
}
