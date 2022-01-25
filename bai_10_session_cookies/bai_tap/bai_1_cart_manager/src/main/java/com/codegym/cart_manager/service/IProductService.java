package com.codegym.cart_manager.service;

import com.codegym.cart_manager.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();

    Optional<Product> findById(Long id);

    void save(Product product);
}
