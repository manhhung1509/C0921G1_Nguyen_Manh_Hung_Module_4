package com.example.demo.service.employee.impl;

import com.example.demo.model.employee.EducationDegree;
import com.example.demo.repository.employee.IEducationDegreeRepository;
import com.example.demo.service.employee.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeService implements IEducationDegreeService {
    @Autowired
    IEducationDegreeRepository educationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }
}
