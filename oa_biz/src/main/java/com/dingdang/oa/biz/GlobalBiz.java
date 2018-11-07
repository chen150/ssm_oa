package com.dingdang.oa.biz;

import com.dingdang.oa.entity.Employee;

public interface GlobalBiz {

    Employee login(String sn,String password);

    void changePassword(Employee employee);
}
