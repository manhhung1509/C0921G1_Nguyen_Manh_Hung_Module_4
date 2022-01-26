package com.example.blog_restful.service.impl;

import com.example.blog_restful.model.Category;
import com.example.blog_restful.repository.ICategoryRepository;
import com.example.blog_restful.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override


    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void remove(Integer id) {
        categoryRepository.deleteById(id);
    }

}