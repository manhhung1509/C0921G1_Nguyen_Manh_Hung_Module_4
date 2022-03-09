package com.example.demo.controller;

import com.example.demo.dto.CustomerDto;
import com.example.demo.model.customer.Customer;
import com.example.demo.model.customer.CustomerType;
import com.example.demo.service.customer.ICustomerService;
import com.example.demo.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @ModelAttribute(value = "customerTypes")
    public List<CustomerType> customerTypes() {
        return customerTypeService.findAll();
    }

    @GetMapping(value = "/customers")
    public ModelAndView listCustomer(@RequestParam("customerName") Optional<String> customerName,
                                     @RequestParam("email") Optional<String> email,
                                     @RequestParam("address") Optional<String> address,
                                     @PageableDefault(value = 4) Pageable pageable) {

        ModelAndView  modelAndView = new ModelAndView("customer/list");
        Page<Customer> customers ;

        if (!customerName.isPresent() && !email.isPresent() && !address.isPresent()){
            customers = customerService.findAll(pageable);
            modelAndView.addObject("customers", customers);
            if (pageable.getPageNumber() > customers.getTotalPages()){
                return new ModelAndView("/error_404");
            }
        }else {
            customers  = customerService.searchCustomerContaining(customerName.orElse(""), email.orElse(""),address.orElse(""),pageable);
            modelAndView.addObject("customers",customers);
            modelAndView.addObject("customerName",customerName.orElse(""));
            modelAndView.addObject("email",email.orElse(""));
            modelAndView.addObject("address",address.orElse(""));
            if (pageable.getPageNumber() > customers.getTotalPages()){
                return new ModelAndView("/error_404");
            }
        }
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
        if (customerService.checkCustomerCodeExits(customerDto.getCustomerCode())) {
            bindingResult.rejectValue("customerCode", "customerCode", "Customer code was exits. Enter again!");
        }
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("customer/create");
            modelAndView.addAllObjects(bindingResult.getModel());
            return modelAndView;
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            ModelAndView modelAndView = new ModelAndView("/customer/create");
            modelAndView.addObject("customer", customer);
            modelAndView.addObject("message", "new customer created successfully");
            return modelAndView;
        }
    }

    @GetMapping(value = {"/edit-customer/{id}"})
    public ModelAndView showEditCustomer(@PathVariable Integer id) {
        Customer customer = customerService.findCustomerById(id);
        if (customer == null){
            return new ModelAndView("error_404");
        }else {
            CustomerDto customerDto = new CustomerDto();
            BeanUtils.copyProperties(customer,customerDto);
            ModelAndView modelAndView = new ModelAndView("customer/edit");
            modelAndView.addObject("customerDto", customerDto);
            return modelAndView;
        }
    }

    @PostMapping(value = "/edit-customer")
    public ModelAndView editCustomer(@Validated @ModelAttribute CustomerDto customerDto, BindingResult bindingResult) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("customer/edit");
            modelAndView.addAllObjects(bindingResult.getModel());
            return modelAndView;
        } else {
            customerService.save(customer);
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customer", customer);
            modelAndView.addObject("message", "Update customer successfully");
            return modelAndView;
        }
    }

    @GetMapping(value = {"/delete-customer/{id}"})
    public ModelAndView showDeleteCustomer(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("customer/table_delete");
        modelAndView.addObject("customer",customerService.findCustomerById(id));
        return modelAndView;
    }

    @PostMapping(value = {"/delete-customer/{id}"})
    public ModelAndView DeleteCustomer(@PathVariable Integer id, @PageableDefault(value = 4) Pageable pageable) {
        Customer customer = customerService.findCustomerById(id);
        customerService.delete(customer);
        Page<Customer> customers;
        ModelAndView modelAndView = new ModelAndView("customer/list_copy");
        modelAndView.addObject("customers", customerService.findAll(pageable));
        return modelAndView;
    }

}
