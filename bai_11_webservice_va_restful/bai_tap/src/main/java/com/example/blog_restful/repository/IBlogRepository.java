package com.example.blog_restful.repository;

import com.example.blog_restful.model.Blog;
import com.example.blog_restful.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findByNameContaining(String name, Pageable pageable);

    Iterable<Blog> findAllByCategory(Category category);

    List<Blog> findBlogByCategoryId(Integer id);
}