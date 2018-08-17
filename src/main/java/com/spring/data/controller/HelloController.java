package com.spring.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    //使用springboot为我们配置好的jdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @ResponseBody//把输出的值转换为json格式
    @RequestMapping("/hello")
    public Map<String, Object> getAllDept(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from dept");
        System.out.println(list.get(0));
        return list.get(0);
    }
}
