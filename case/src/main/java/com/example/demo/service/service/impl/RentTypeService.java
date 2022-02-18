package com.example.demo.service.service.impl;

import com.example.demo.model.service.RentType;
import com.example.demo.repository.service.IRentTypeRepository;
import com.example.demo.service.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    IRentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
