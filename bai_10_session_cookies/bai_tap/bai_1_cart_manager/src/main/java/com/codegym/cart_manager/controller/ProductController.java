package com.codegym.cart_manager.controller;

import com.codegym.cart_manager.dto.CartDto;
import com.codegym.cart_manager.dto.ProductDto;
import com.codegym.cart_manager.model.Product;
import com.codegym.cart_manager.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@SessionAttributes("cart")
@Controller
@RequestMapping(value = "/shop")
public class ProductController {
    @Autowired
    IProductService productService;


    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @GetMapping
    public ModelAndView showListPage() {
        ModelAndView modelAndView = new ModelAndView("product/list");
        modelAndView.addObject("productList", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView addToDetail(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("product/detail");
        modelAndView.addObject("product", productService.findById(id).get());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCard(@PathVariable Long id,
                            @SessionAttribute("cart") CartDto cartDto,
                            @RequestParam(value = "action", required = false) String action) {
        Optional<Product> productOptional = productService.findById(id);

        if (productOptional.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(), productDto);
            if ("add".equals(action)) {
                cartDto.addProduct(productDto);
                return "redirect:/cart";
            }
            if ("sub".equals(action)) {
                cartDto.subProduct(productDto);
                return "redirect:/cart";
            }
            cartDto.addProduct(productDto);
        }

        return "redirect:/cart";
    }
}
