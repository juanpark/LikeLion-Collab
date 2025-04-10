package com.mysqlapp.view;

import com.mysqlapp.model.Dept;
import java.util.List;

public class DeptView {
    public void display(List<Dept> list) {
        for (Dept d : list) {
            System.out.println(d.deptno() + " - " + d.dname() + " - " + d.loc());
        }
    }
}