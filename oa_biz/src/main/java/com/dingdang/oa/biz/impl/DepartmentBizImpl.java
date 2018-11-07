package com.dingdang.oa.biz.impl;

import com.dingdang.oa.biz.DepartmentBiz;
import com.dingdang.oa.dao.DepartmentDao;
import com.dingdang.oa.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentBizImpl implements DepartmentBiz {

    @Autowired
    private DepartmentDao departmentDao;

    public void add(Department department) {
        departmentDao.insert(department);
    }

    public void edit(Department department) {
        departmentDao.update(department);
    }

    public void remove(String sn) {
        departmentDao.delete(sn);
    }

    public Department get(String sn) {
        return departmentDao.selete(sn);
    }

    public List<Department> getAll() {
        return departmentDao.getAll();
    }
}
