package com.example.blog_restful.controller;

import com.example.blog_restful.model.Blog;
import com.example.blog_restful.model.Category;
import com.example.blog_restful.service.IBlogService;
import com.example.blog_restful.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/rest")
public class RestController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IBlogService blogService;

    //Xem danh sách các category
    @GetMapping(value = "/category")
    public ResponseEntity<List<Category>> getListCategory() {
        List<Category> categories = this.categoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    //    Xem danh sách các bài viết
    @GetMapping(value = "/blog")
    public ResponseEntity<List<Blog>> getListBlog() {
        List<Blog> blogs = this.blogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }


//    Xem danh sách các bài viết của một category

    @GetMapping(value = "/blog-category/{id}")
    public ResponseEntity<List<Blog>> getCategoryOfBlog(@PathVariable Integer id) {
        List<Blog> blogs = this.blogService.findCategoryOfBlog(id);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    //Xem chi tiết một bài viết
    @GetMapping(value = "/detail-blog/{id}")
    public ResponseEntity<Blog> getInfoBlog(@PathVariable Integer id) {
        Blog blog = this.blogService.findById(id).orElse(null);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}