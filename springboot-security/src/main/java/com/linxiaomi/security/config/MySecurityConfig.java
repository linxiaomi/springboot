package com.linxiaomi.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        // 定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");

        // 开启启动配置登录功能，如果没有登录，没有权限就会来到登录页面
        http.formLogin();
        // 1、login来到登录页面
        // 2、重定向/login?error表示登录失败
        // 3、更多详细规定

        // 开启自动配置的注销功能
        http.logout().logoutSuccessUrl("/"); // 注销成功后来到首页
        // 1、访问 /logout 表示用户注销,清空session
        // 2、注销成功会返回 /login?logout页面

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);

        auth.inMemoryAuthentication().withUser("admin").password("123456").roles("VIP1", "VIP2")
                .and()
                .withUser("guest").password("123456").roles("VIP2", "VIP3")
                .and()
                .withUser("linxiaomi").password("123456").roles("VIP1", "VIP3");

    }
}
