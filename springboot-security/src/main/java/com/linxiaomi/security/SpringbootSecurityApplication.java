package com.linxiaomi.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1、引入SpringSecurity;
 * 2、编写SpringSecurity配置类;
 *    @EnableWebSecurity extends WebSecurityConfigurerAdapter
 * 3、控制请求的范文权限
 */
@SpringBootApplication
public class SpringbootSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSecurityApplication.class, args);
	}

}

