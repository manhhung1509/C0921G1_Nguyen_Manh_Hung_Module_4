package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
         blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findByCategoryId(Long id, Pageable pageable) {
        return blogRepository.findBlogByCategoryId(id, pageable);
    }

    @Override
    public Page<Blog> findBlogByName(String name, Pageable pageable) {
        return blogRepository.findBlogByNameContaining(name, pageable);
    }


}