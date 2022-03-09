package com.example.demo.service.contract.impl;

import com.example.demo.model.contract.AttachService;
import com.example.demo.repository.contract.IAttachServiceRepository;
import com.example.demo.service.contract.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class attachServiceService implements IAttachServiceService {

    @Autowired
    IAttachServiceRepository attachServiceRepository;
    @Override
    public Iterable<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }
}
