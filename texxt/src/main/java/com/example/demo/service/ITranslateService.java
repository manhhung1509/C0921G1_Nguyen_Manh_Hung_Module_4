package com.example.demo.service;

import com.example.demo.model.Translate;


import java.util.List;

public interface ITranslateService {
    List <Translate> findAll();

    void save(Translate translate);

    Translate findTranslateById(Integer id);

    void delete (Translate translate);

    List<Translate> searchTranslateContaining(String serviceType, String customerName);
}
