package com.dingdang.oa.dao;

import com.dingdang.oa.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("departmentDao")
public interface DepartmentDao {

    void insert(Department department);

    void update(Department department);

    void delete(String sn);

    Department selete(String sn);

    List<Department> getAll();
}
