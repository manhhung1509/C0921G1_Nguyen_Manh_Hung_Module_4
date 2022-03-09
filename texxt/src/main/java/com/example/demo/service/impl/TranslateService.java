package com.example.demo.service.impl;


import com.example.demo.model.Translate;
import com.example.demo.repository.ITranslateRepository;
import com.example.demo.service.ITranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TranslateService implements ITranslateService {

    @Autowired
    ITranslateRepository translateRepository;

    @Override
    public List<Translate> findAll() {
        return translateRepository.findAll();
    }

    @Override
    public void save(Translate translate) {
        translate.setFlag("1");
        translateRepository.save(translate);
    }

    @Override
    public Translate findTranslateById(Integer id) {
        return translateRepository.findTranslateById(id);
    }

    @Override
    public void delete(Translate translate) {
        translate.setFlag("0");
        translateRepository.save(translate);
    }

    @Override
    public List<Translate> searchTranslateContaining(String serviceType, String customerName) {
        return translateRepository.searchTranslate(serviceType, customerName);
    }
}
