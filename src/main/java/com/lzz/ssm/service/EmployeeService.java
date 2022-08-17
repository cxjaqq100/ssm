package com.lzz.ssm.service;

import com.github.pagehelper.PageInfo;
import com.lzz.ssm.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    //查询所有员工信息
    List<Employee> getAllEmployee();

    PageInfo getAllEmployeePage(Integer pageNum);
}
