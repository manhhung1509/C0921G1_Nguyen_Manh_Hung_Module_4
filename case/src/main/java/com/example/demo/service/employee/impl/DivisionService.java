package com.example.demo.service.employee.impl;

import com.example.demo.model.employee.Division;
import com.example.demo.repository.employee.IDivisionRepository;
import com.example.demo.service.employee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DivisionService implements IDivisionService{
    @Autowired
    IDivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }
}
