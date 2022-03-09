package com.example.demo.service.service;

import com.example.demo.model.service.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceService {
    Iterable<Services> findAll();

    Page<Services> findAll(Pageable page);

    void save(Services services);
}
