package com.example.blog_restful.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    List<T> findAll();

    Optional<T> findById(Integer id);

    void save(T t);

    void remove(Integer id);
}