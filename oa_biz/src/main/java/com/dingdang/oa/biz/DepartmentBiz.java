package com.dingdang.oa.biz;

import com.dingdang.oa.entity.Department;

import java.util.List;

public interface DepartmentBiz {

    void add(Department department);

    void edit(Department department);

    void remove(String sn);

    Department get(String sn);

    List<Department> getAll();
}
