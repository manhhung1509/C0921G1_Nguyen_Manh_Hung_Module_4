package com.example.demo.service.impl;


import com.example.demo.repository.IServiceTypeRepository;
import com.example.demo.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceType implements IServiceTypeService {
    @Autowired
    IServiceTypeRepository serviceTypeRepository;

    @Override
    public List<com.example.demo.model.ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
