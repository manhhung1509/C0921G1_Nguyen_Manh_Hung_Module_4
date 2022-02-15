package com.example.demo.controller;

import com.example.demo.dto.CustomerDto;
import com.example.demo.model.customer.Customer;
import com.example.demo.model.customer.CustomerType;
import com.example.demo.service.ICustomerService;
import com.example.demo.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @Autowired
    ICustomerTypeService customerTypeService;

    @ModelAttribute(value = "customerTypes")
    public List<CustomerType> customerTypes() {
        return customerTypeService.findAll();
    }

    @GetMapping(value = "/customers")
    public ModelAndView listCustomer(@PageableDefault(value = 2) Pageable pageable) {
        Page<Customer> customers;
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customerService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping(value = {"/create-customer"})
    public ModelAndView showCreateCustomer() {
        CustomerDto customerDto = new CustomerDto();
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customerDto", customerDto);
        return modelAndView;
    }

    @PostMapping(value = "/create-customer")
    public ModelAndView saveCustomer(@Validated @ModelAttribute CustomerDto customerDto, BindingResult bindingResult) {
        List<CustomerType> customerTypes = (List<CustomerType>) customerTypeService.findAll();
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("customer/create");
            modelAndView.addAllObjects(bindingResult.getModel());
            return modelAndView;
        } else {
            customerService.save(customer);
            ModelAndView modelAndView = new ModelAndView("/customer/create");
            modelAndView.addObject("customer", customer);
            modelAndView.addObject("message", "new customer created successfully");
            return modelAndView;
        }
    }

    @GetMapping(value = {"/delete-customer/{id}"})
    public ModelAndView showDeleteCustomer(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("customer/table_delete");
        modelAndView.addObject("customer",customerService.findCustomerById(id));
        return modelAndView;
    }
}
