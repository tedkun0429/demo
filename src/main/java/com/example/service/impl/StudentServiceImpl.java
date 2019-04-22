package com.example.service.impl;

import com.example.entity.Student;
import com.example.repository.StuRepository;
import com.example.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Resource
    private StuRepository stuRepository;

    @Override
    public void add(Student student) {
        stuRepository.save(student);
    }
}
