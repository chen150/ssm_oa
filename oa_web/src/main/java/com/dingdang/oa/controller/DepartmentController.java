package com.dingdang.oa.controller;

import com.dingdang.oa.biz.DepartmentBiz;
import com.dingdang.oa.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/department/")
public class DepartmentController {

    @Autowired
    private DepartmentBiz departmentBiz;

    /**
     * 部门列表
     * @param map
     * @return
     */
    @RequestMapping("list")
    public String List(Map<String,Object> map) {
        map.put("list",departmentBiz.getAll());
        return "department_list";
    }

    /**
     * 跳转添加页面
     * @param map
     * @return
     */
    @RequestMapping("to_add")
    public String toAdd(Map<String,Object> map) {
        map.put("department",new Department());
        return "department_add";
    }

    /**
     * 部门添加
     * @param department
     * @return
     */
    @RequestMapping("add")
    public String add(Department department) {
        departmentBiz.add(department);
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
        map.put("department",departmentBiz.get(sn));
        return "department_update";
    }

    /**
     * 修改部门
     * @param department
     * @return
     */
    @RequestMapping("update")
    public String update(Department department) {
        departmentBiz.edit(department);
        return "redirect:list";
    }


    /**
     * 删除部门
     * @param sn
     * @return
     */
    @RequestMapping("remove")
    public String remove(@RequestParam("sn") String sn) {
        departmentBiz.remove(sn);
        return "redirect:list";
    }



}
