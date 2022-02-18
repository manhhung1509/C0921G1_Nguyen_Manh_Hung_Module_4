package com.example.demo.service.customer;

import com.example.demo.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> findAll(Pageable page);

    void save(Customer customer);

    Customer findCustomerById(Integer id);

    void delete (Integer id);

    Page<Customer> searchCustomerContaining(String name, String email, String address, Pageable pageable);
}
