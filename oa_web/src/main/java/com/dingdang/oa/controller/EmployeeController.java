package com.dingdang.oa.controller;


import com.dingdang.oa.biz.DepartmentBiz;
import com.dingdang.oa.biz.EmployeeBiz;
import com.dingdang.oa.entity.Employee;
import com.dingdang.oa.global.Contant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/employee/")
public class EmployeeController {

    @Autowired
    private EmployeeBiz employeeBiz;

    @Autowired
    private DepartmentBiz departmentBiz;


    /**
     * 用户列表
     * @param map
     * @return
     */
    @RequestMapping("list")
    public String list(Map<String,Object> map) {
        map.put("list",employeeBiz.getAll());
        return "employee_list";
    }

    /**
     * 跳转添加页面
     * @param map
     * @return
     */
    @RequestMapping("to_add")
    public String toAdd(Map<String,Object> map) {
        map.put("employee",new Employee());
        map.put("dlist",departmentBiz.getAll());
        map.put("plist",Contant.getPost());
        return "employee_add";
    }

    /**
     * 添加用户
     * @param employee
     * @return
     */
    @RequestMapping("add")
    public String add(Employee employee) {
        employeeBiz.add(employee);
        return "redirect:list";
    }

    /**
     * 跳转修改页面
     * @param map
     * @param sn
     * @return
     */
    @RequestMapping("to_update")
    public String toUpdate(Map<String,Object> map,@RequestParam("sn") String sn) {
        map.put("employee",employeeBiz.get(sn));
        map.put("dlist",departmentBiz.getAll());
        map.put("plist",Contant.getPost());
        return "employee_update";
    }

    /**
     * 修改用户
     * @param employee
     * @return
     */
    @RequestMapping("update")
    public String update(Employee employee) {
        employeeBiz.edit(employee);
        return "redirect:list";
    }

    /**
     * 删除用户
     * @param sn
     * @return
     */
    @RequestMapping("remove")
    public String remove(String sn) {
        employeeBiz.remove(sn);
        return "redirect:list";
    }
}
