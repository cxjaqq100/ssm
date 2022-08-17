package com.lzz.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.lzz.ssm.pojo.Employee;
import com.lzz.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/*
* 查询所有员工信息-->/employee-->get
* 查询所有分页的员工信息-->/employee/page/1-->get
* 根据id查询员工信息-->/employee/1-->get
* 跳转到添加页面-->/to/add-->get
* 添加员工信息-->/employee-->post
* 修改员工信息-->/employee-->put
* 删除员工信息-->/employee/1-->delete
* */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee/page/{pageNum}",method = RequestMethod.GET)
    public String getAllEmployeePage(@PathVariable("pageNum") Integer pageNum,Model model){
        PageInfo page = employeeService.getAllEmployeePage(pageNum);
        //将员工信息在请求域中共享
        model.addAttribute("page",page);
        //跳转到employee_list页面
        return "employee_list";
    }


    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        //查询所有员工信息
        List<Employee> listemp = employeeService.getAllEmployee();
        //将员工信息在请求域中共享
        model.addAttribute("listemp",listemp);
        //跳转到employee_list页面
        return "employee_list";
    }
}
