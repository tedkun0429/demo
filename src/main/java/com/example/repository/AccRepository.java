package com.example.repository;

import com.example.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccRepository extends JpaRepository<Account, Integer> {
}
