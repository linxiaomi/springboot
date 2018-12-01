package com.linxiaomi.springboot;

import com.linxiaomi.springboot.bean.Person;
import com.linxiaomi.springboot.bean.PersonProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot02ConfigApplicationTests {

	@Autowired
	Person person;

	@Autowired
	PersonProperties personProperties;

	@Autowired
	ApplicationContext ioc;

	@Test
	public void contextLoads() {
		System.out.println(personProperties);
	}

	@Test
	public void testHelloService() {
		//
		boolean flag = ioc.containsBean("helloService");
		// false 说明Spring Boot里面没有Spring的配置文件，我们自己编写的配置文件，也不能自动识别
		// 想让Spring的配置文件生效，加载进来 需要@ImportResource
		System.out.println(flag);
	}

	@Test
	public void propertiesRandom() {
		System.out.println(person);
	}
}
