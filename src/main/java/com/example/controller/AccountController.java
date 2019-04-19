package com.example.controller;

import com.example.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @RequestMapping(value = "/transfer")
    public String transferMoney() {
        try{
            accountService.transferMoney(1,2,10);
            return "Okay";
        }catch(Exception e){
            return "No!!!";
        }
    }
}
