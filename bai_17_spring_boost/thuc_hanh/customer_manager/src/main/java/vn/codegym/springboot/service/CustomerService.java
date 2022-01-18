package vn.codegym.springboot.service;

import vn.codegym.springboot.model.Customer;

import java.util.Optional;


public interface CustomerService {
    Iterable<Customer> findAll();

    Optional<Customer> finById(Integer id);

    void save(Customer customer);

    void remove(Integer id);

}
