package com.example.demo.controller;


import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/blog")
    public ModelAndView listBlog(Optional<String> nameBlog,
                                 Optional<Long> cateId,
                                 @PageableDefault(size = 5, sort = "date", direction = Sort.Direction.DESC) Pageable pageable) {

        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("categoryList", categoryService.findAll());
        if (!nameBlog.isPresent() || nameBlog.get().equals("")) {
            if (!cateId.isPresent()) {
                modelAndView.addObject("blogs", blogService.findAll(pageable));
            } else {
                modelAndView.addObject("cateId", cateId.get());
                modelAndView.addObject("blogs",blogService.findByCategoryId(cateId.get(), pageable));
            }
        } else {
            modelAndView.addObject("nameBlog", nameBlog.get());
            modelAndView.addObject("blogs", blogService.findBlogByName(nameBlog.get(), pageable));
        }
        return modelAndView;

    }

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("categoryList", categoryService.findAll(pageable));
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView saveCustomer(@ModelAttribute("blog") Blog blog, Pageable pageable) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("categoryList", categoryService.findAll(pageable));
        modelAndView.addObject("message", "New Blog created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Long id, Pageable pageable) {
        Optional<Blog> blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("categoryList", categoryService.findAll(pageable));
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @PostMapping("/edit-blog")
    public ModelAndView updateCustomer(@ModelAttribute("blog") Blog blog, Pageable pageable) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("categoryList", categoryService.findAll(pageable));
        modelAndView.addObject("message", "Blog updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/blog/delete");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @PostMapping("/delete-blog")
    public String deleteCustomer(@ModelAttribute("blog") Blog blog) {
        blogService.delete(blog.getId());
        return "redirect:blog";
    }

    @GetMapping("/view-blog/{id}")
    public ModelAndView viewDetailBlog(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/blog/view");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }
}
