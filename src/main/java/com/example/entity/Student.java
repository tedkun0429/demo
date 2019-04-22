package com.example.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "stu_tbl")
public class Student {
    @javax.persistence.Id
    @GeneratedValue
    private Integer Id;

    @NotEmpty(message = "姓名不能为空!")
    @Column(length = 50)
    private String name;

    @NotNull(message = "年龄不能为空!")
    @Min(value = 18, message = "年龄不能低于18岁!")
    @Column
    private Integer age;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
