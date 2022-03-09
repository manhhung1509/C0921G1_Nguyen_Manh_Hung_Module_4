package com.example.demo.service.customer;

import com.example.demo.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Iterable <Customer> findAll();

    Page<Customer> findAll(Pageable page);

    void save(Customer customer);

    Customer findCustomerById(Integer id);

    void delete (Customer customer);

    Page<Customer> searchCustomerContaining(String name, String email, String address, Pageable pageable);

    Boolean checkCustomerCodeExits(String customerCode);
}
