package com.example.demo.service;

import com.example.demo.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> findAll(Pageable page);

    Page<Customer> findCustomerByNameContaining(String name, Pageable pageable);

    void save(Customer customer);

    Customer findCustomerById(Integer id);
}
