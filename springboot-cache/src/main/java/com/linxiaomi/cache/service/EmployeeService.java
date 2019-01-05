package com.linxiaomi.cache.service;

import com.linxiaomi.cache.bean.Employee;
import com.linxiaomi.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    public Employee getEmp(Integer id) {
        return employeeMapper.getEmpById(id);
    }
}
