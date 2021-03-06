package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "book_tbl")
public class Book {

    @Id
    @GeneratedValue
    private Integer Id;

    @Column(length = 100)
    private String name;

    @Column(length = 50)
    private String author;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
