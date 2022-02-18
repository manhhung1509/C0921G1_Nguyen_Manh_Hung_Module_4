package com.example.demo.service.customer.impl;

import com.example.demo.model.customer.CustomerType;
import com.example.demo.repository.customer.ICustomerTypeRepository;
import com.example.demo.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
