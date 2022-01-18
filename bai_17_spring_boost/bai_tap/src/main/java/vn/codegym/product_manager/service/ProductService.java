package vn.codegym.product_manager.service;

import vn.codegym.product_manager.model.Product;

import java.util.Optional;


public interface ProductService {
    Iterable<Product> findAll();

    Optional<Product> finById(Integer id);

    void save(Product product);

    void remove(Integer id);

    Iterable<Product> findByName(String name);

}
