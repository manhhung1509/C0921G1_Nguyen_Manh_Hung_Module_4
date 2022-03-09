package com.example.demo.service.customer.impl;

import com.example.demo.model.customer.Customer;
import com.example.demo.repository.customer.ICustomerRepository;
import com.example.demo.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable page) {
        return customerRepository.findAll(page);
    }

    @Override
    public void save(Customer customer) {
        customer.setFlag("1");
        customerRepository.save(customer);
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return customerRepository.findCustomerById(id);
    }

    @Override
    public void delete(Customer customer) {
        customer.setFlag("0");
        customerRepository.save(customer);
    }

    @Override
    public Page<Customer> searchCustomerContaining(String name, String email, String address, Pageable pageable) {
        return customerRepository.searchCustomer(name, email, address, pageable);
    }

    @Override
    public Boolean checkCustomerCodeExits(String customerCode) {
        System.err.println(customerRepository.existsByCustomerCode(customerCode));;
        return customerRepository.existsByCustomerCode(customerCode);
    }
}
