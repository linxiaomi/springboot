package com.linxiaomi.springboot.controller;

import com.linxiaomi.springboot.entity.User;
import com.linxiaomi.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public List<User> getUser(@PathVariable("id") Integer id) {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @GetMapping("/user")
    public User insertUser(User user) {
        return userRepository.save(user);
    }
}
