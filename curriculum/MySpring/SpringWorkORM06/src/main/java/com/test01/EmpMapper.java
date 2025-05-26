package com.test01;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface EmpMapper {
    @Insert("INSERT INTO emp (ename) VALUES (#{ename})")
    void insertEmp(String ename);

    @Select("SELECT ename FROM emp")
    List<String> selectAll();
}