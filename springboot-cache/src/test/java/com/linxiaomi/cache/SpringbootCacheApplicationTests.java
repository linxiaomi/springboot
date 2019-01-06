package com.linxiaomi.cache;

import com.linxiaomi.cache.bean.Employee;
import com.linxiaomi.cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCacheApplicationTests {

	@Autowired
	EmployeeMapper employeeMapper;

	// 操作字符串
	@Autowired
	StringRedisTemplate stringRedisTemplate;

	// k-v都是对象
	@Autowired
	RedisTemplate redisTemplate;

	@Autowired
	RedisTemplate<Object, Employee> empRedistTemplate;

	/**
	 * String、List、Set、Hash、ZSet(有序集合)
	 * stringRedisTemplate.opsForValue():字符串
	 * stringRedisTemplate.opsForList():List
	 * stringRedisTemplate.opsForSet():Set
	 * ..
	 * ..
	 */
	@Test
	public void test01() {
//		stringRedisTemplate.opsForValue().append("msg", "hello");
//		String msg = stringRedisTemplate.opsForValue().get("msg");
//		System.out.println(msg);

//		stringRedisTemplate.opsForList().leftPush("mylist", "1");
//		stringRedisTemplate.opsForList().leftPush("mylist", "2");
	}

	@Test
	public void test02() {
		Employee employee = employeeMapper.getEmpById(1);
		// 默认如果保存对象,使用jdk序列化机制,序列化后的数据保存到redis中
//		redisTemplate.opsForValue().set("emp01", employee);
		// 1、将数据以json的方式保存
		// 1.1、将对象转为json
		// 1.2、redisTemplate默认的序列化规则：改变默认的序列化规则
		empRedistTemplate.opsForValue().set("emp01", employee);
	}


	@Test
	public void contextLoads() {

		Employee employee = employeeMapper.getEmpById(1);
		System.out.println(employee);
	}

}

