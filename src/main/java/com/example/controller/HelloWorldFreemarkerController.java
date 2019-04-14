package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/freemarker")
public class HelloWorldFreemarkerController {

    @RequestMapping(value = "/say")
    public ModelAndView sayHello() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", "springboot hello");
        mav.setViewName("HelloWorld");
        return mav;
    }
}
