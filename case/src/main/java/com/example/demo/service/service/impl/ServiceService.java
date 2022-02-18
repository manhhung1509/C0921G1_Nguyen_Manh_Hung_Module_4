package com.example.demo.service.service.impl;

import com.example.demo.model.service.Services;
import com.example.demo.repository.service.IServiceRepository;
import com.example.demo.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceService implements IServiceService {
    @Autowired
    IServiceRepository serviceRepository;


    @Override
    public Page<Services> findAll(Pageable page) {
        return serviceRepository.findAll(page);
    }

    @Override
    public void save(Services services) {
        serviceRepository.save(services);
    }
}
