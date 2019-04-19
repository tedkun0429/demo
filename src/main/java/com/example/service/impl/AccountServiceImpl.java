package com.example.service.impl;

import com.example.entity.Account;
import com.example.repository.AccRepository;
import com.example.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * 账户实现类
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccRepository accRepository;

    @Transactional
    @Override
    public void transferMoney(Integer fromUserId, Integer toUserId, float amount) {
        Account accountFrom = accRepository.getOne(fromUserId);
        accountFrom.setBalance(accountFrom.getBalance()-amount);
        accRepository.save(accountFrom);

        int wrong = 1/0;
        Account accountTo = accRepository.getOne(toUserId);
        accountTo.setBalance(accountTo.getBalance()+amount);
        accRepository.save(accountTo);
    }
}
