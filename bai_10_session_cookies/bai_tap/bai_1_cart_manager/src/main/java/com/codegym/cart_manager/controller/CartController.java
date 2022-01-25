package com.codegym.cart_manager.controller;


import com.codegym.cart_manager.dto.CartDto;
import com.codegym.cart_manager.dto.ProductDto;
import com.codegym.cart_manager.model.Product;
import com.codegym.cart_manager.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping(value = "/cart")
public class CartController {
    @Autowired
    IProductService productService;

    @GetMapping
    public ModelAndView showCart(@SessionAttribute(name = "cart", required = false) CartDto cart){
        return  new ModelAndView("cart/list", "cart",cart);
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@SessionAttribute(name = "cart", required = false) CartDto cart,@PathVariable Long id){
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(), productDto);
            cart.removeProduct(productDto);
        }
        return "redirect:/cart";
    }
}
