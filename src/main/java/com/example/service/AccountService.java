package com.example.service;

/**
 * 账户service接口
 */
public interface AccountService {

    /**
     * 转账--从A用户转账到B用户
     * @param fromUserId
     * @param toUserId
     * @param amount
     */
    public void transferMoney(Integer fromUserId, Integer toUserId, float amount);
}
