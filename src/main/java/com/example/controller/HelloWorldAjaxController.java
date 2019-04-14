package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ajax")
public class HelloWorldAjaxController {

    @RequestMapping(value = "/show")
    public String sayAjaxHello(){
        return "{'message1':'Springboot1','message2':'Springboot2'}";
    }
}
