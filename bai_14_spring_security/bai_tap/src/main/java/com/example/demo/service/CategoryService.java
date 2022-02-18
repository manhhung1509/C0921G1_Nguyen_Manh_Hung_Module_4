package com.example.demo.service;

import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface CategoryService {
     Page<Category> findAll(Pageable pageable);

     List<Category> findAll();

     void save(Category category);

     Optional<Category> findById(Long id);

     void delete(Long id);
}
