package com.example.blog_restful.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String author;
    private String name;
    private String content;
    private Date date=new Date();



    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id" ,referencedColumnName = "id")
    private Category category;

    public Blog(Integer id, String author, String name, String content, Date date, Category category) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.content = content;
        this.date = date;
        this.category = category;
    }

    public Blog(String author, String name, String content, Date date, Category category) {
        this.author = author;
        this.name = name;
        this.content = content;
        this.date = date;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Blog() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
