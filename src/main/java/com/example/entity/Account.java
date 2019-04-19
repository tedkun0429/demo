package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "acc_tbl")
public class Account {

    @Id
    @GeneratedValue
    private Integer Id;

    @Column(length = 50)
    private String userName;

    @Column
    private float balance;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
