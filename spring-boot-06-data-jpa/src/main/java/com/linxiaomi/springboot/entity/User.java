package com.linxiaomi.springboot.entity;

import javax.persistence.*;

// 使用JPA注解配置映射关系
@Entity
@Table(name="tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增主键
    private Integer id;
    @Column(name="last_name", length = 50) // 和数据表对应的一个列
    private String lastName;
    @Column
    private String email; // 省略 默认列名就是属性名

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
