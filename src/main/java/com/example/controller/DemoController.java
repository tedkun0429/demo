package com.example.controller;

import com.example.properties.MysqlProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DemoController {
    @Resource
    private MysqlProperties mysqlProperties;

    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }

    @RequestMapping("/showProperties")
    public String showProperties() {
        return "mysql.jdbcName:" + mysqlProperties.getJdbcName() + "<br>"
                + "mysql.dbUrl:" + mysqlProperties.getDbUrl() + "<br>"
                + "mysql.userName:" + mysqlProperties.getUserName() + "<br>"
                + "mysql.password:" + mysqlProperties.getPassword() + "<br>"
                + "mysql.testStr:" + mysqlProperties.getTestStr() + "<br>";
    }
}