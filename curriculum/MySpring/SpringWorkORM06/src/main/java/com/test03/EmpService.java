package com.test03;

import com.test01.EmpMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.transaction.annotation.Transactional;

public class EmpService {
    private final SqlSessionTemplate sqlSessionTemplate;

    public EmpService(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Transactional
    public void insertThenFail(String name) {
        EmpMapper mapper = sqlSessionTemplate.getMapper(EmpMapper.class);
        mapper.insertEmp(name);
        System.out.println("INSERT 성공 후 예외 발생 예정");
        throw new RuntimeException("강제 예외");
    }
}