package com.example.demo.service.customer;

import com.example.demo.model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
}
