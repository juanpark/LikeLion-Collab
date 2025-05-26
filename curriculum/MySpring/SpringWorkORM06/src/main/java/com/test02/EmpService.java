package com.test02;

import com.test01.EmpMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class EmpService {
    private SqlSessionFactory sqlSessionFactory;

    public EmpService(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public void insertEmp(String name) {
        try (SqlSession session = sqlSessionFactory.openSession(false)) {
            EmpMapper mapper = session.getMapper(EmpMapper.class);
            mapper.insertEmp(name);
            session.commit();
            System.out.println("COMMIT 완료");
        } catch (Exception e) {
            System.out.println("ROLLBACK 발생: " + e.getMessage());
        }
    }
}