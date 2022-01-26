package com.example.blog_restful.service.impl;

import com.example.blog_restful.model.Blog;
import com.example.blog_restful.model.Category;
import com.example.blog_restful.repository.IBlogRepository;
import com.example.blog_restful.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }


    @Override
    public Page<Blog> findAllByNameContaining(String name, Pageable pageable) {
        return blogRepository.findByNameContaining(name, pageable);
    }

    @Override
    public List<Blog> findCategoryOfBlog( Integer id) {
        return blogRepository.findBlogByCategoryId(id);
    }

    @Override
    public Iterable<Blog> findAllByProvince(Category category) {
        return blogRepository.findAllByCategory(category);
    }

    @Override
    public List<Blog> findAll() {
        return (List<Blog>) blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Integer id) {
        blogRepository.deleteById(id);

    }

}