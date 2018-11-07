package com.dingdang.oa.controller;

import com.dingdang.oa.biz.GlobalBiz;
import com.dingdang.oa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class GlobalController {

    @Autowired
    private GlobalBiz globalBiz;

    /**
     * 跳转登陆页面
     * @return
     */
    @RequestMapping("/to_login")
    public String toLogin() {
        return "login";
    }

    /**
     * 登陆
     * @param sn
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public String login(@RequestParam("sn") String sn,@RequestParam("password") String password, HttpSession session) {
        Employee employee = globalBiz.login(sn,password);
        if (employee != null) {
            session.setAttribute("employee",employee);
            return "redirect:self";
        }
        return "redirect:to_login";
    }

    /**
     * 用户信息
     * @return
     */
    @RequestMapping("/self")
    public String self() {
        return "self";
    }

    /**
     * 退出
     * @param session
     * @return
     */
    @RequestMapping("/quit")
    public String quit(HttpSession session) {
        session.setAttribute("employee",null);
        return "redirect:to_login";
    }

    /**
     * 跳转修改密码页面
     * @return
     */
    @RequestMapping("/to_change_password")
    public String toChangePassword() {
        return "change_password";
    }

    /**
     * 修改密码
     * @param session
     * @param old
     * @param new1
     * @param new2
     * @return
     */
    @RequestMapping("/change_password")
    public String changePassword(HttpSession session,
                                 @RequestParam("old") String old,
                                 @RequestParam("new1") String new1,
                                 @RequestParam("new2") String new2) {
        Employee employee = (Employee) session.getAttribute("employee");
        if (employee.getPassword().equals(old)) {
            if (new1.equals(new2)) {
                employee.setPassword(new1);
                globalBiz.changePassword(employee);
                return "redirect:self";
            }
        }
        return "redirect:to_change_password";
    }
}
