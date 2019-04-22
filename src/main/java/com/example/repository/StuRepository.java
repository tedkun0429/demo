package com.example.repository;

import com.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StuRepository extends JpaRepository<Student, Integer> {
}
