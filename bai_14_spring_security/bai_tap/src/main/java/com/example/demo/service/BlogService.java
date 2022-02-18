package com.example.demo.service;


import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface BlogService {
     Page<Blog> findAll(Pageable pageable);

     void save(Blog blog);

     Optional<Blog> findById(Long id);

     void delete(Long id);

    Page<Blog> findByCategoryId(Long id,Pageable pageable);

    Page<Blog> findBlogByName(String name, Pageable pageable);
}
