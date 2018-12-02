package com.linxiaomi.springboot.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloWorld {

    @RequestMapping({"/","/index.html"})
    public String index() {
        return "index";
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello", "你好");
        map.put("users", Arrays.asList("大黄", "旺财", "小黑"));
        return "success";
    }
}
