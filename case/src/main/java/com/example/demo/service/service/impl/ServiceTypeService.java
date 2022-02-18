package com.example.demo.service.service.impl;

import com.example.demo.model.service.ServiceType;
import com.example.demo.repository.service.IServiceTypeRepository;
import com.example.demo.service.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeService implements IServiceTypeService {
    @Autowired
    IServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll() ;
    }
}
