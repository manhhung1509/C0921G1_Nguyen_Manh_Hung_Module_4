package com.example.blog_restful.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @JsonBackReference
    @OneToMany(targetEntity = Blog.class)
    private List<Blog> blogs;

    public Category(Integer id, String name, List<Blog> blogs) {
        this.id = id;
        this.name = name;
        this.blogs = blogs;
    }

    public Category(String name, List<Blog> blogs) {
        this.name = name;
        this.blogs = blogs;
    }

    public Category() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}