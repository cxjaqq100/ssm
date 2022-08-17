package com.lzz.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzz.ssm.mapper.EmployeeMapper;
import com.lzz.ssm.pojo.Employee;
import com.lzz.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    public PageInfo getAllEmployeePage(Integer pageNum) {
        //开启分页功能
        PageHelper.startPage(pageNum,3);
        //查询所有的员工信息
        List<Employee> list = employeeMapper.getAllEmployee();
        //获取分页相关信息
        PageInfo<Employee> page = new PageInfo<Employee>(list,3);
        return page;
    }

}
