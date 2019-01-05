package com.linxiaomi.cache;

import com.linxiaomi.cache.bean.Employee;
import com.linxiaomi.cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCacheApplicationTests {

	@Autowired
	EmployeeMapper employeeMapper;

	@Test
	public void contextLoads() {

		Employee employee = employeeMapper.getEmpById(1);
		System.out.println(employee);
	}

}

