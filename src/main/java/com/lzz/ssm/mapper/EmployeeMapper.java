package com.lzz.ssm.mapper;

import com.lzz.ssm.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {
    //查询所有员工信息
    List<Employee> getAllEmployee();
}
