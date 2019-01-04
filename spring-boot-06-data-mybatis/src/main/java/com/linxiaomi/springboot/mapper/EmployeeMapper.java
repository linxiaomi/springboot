package com.linxiaomi.springboot.mapper;

import com.linxiaomi.springboot.bean.Employee;

public interface EmployeeMapper {

    Employee getEmpById(Integer id);

    void inserEmp(Employee employee);
}
