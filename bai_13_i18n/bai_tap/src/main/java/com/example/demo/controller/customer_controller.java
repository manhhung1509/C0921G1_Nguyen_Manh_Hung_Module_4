package com.example.demo.controller;

import com.example.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class customer_controller {
    @Autowired
    ICustomerService customerService;

    @GetMapping("/list")
    public ModelAndView getListCustomer(){
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("customerList",customerService.findAll());
        return modelAndView;
    }
}
