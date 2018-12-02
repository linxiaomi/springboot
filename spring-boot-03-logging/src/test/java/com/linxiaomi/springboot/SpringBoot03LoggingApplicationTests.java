package com.linxiaomi.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot03LoggingApplicationTests {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void contextLoads() {
		// 日志级别 由低到高
		// spring boot默认使用的是info级别的
		// 日志级别可以在application.properties里设置
		logger.trace("this is trace log");
		logger.debug("this is debug log");
		logger.info("this is info log");
		logger.warn("this is warn log");
		logger.error("this is error log");
	}

}
