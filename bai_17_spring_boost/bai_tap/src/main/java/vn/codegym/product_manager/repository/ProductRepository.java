package vn.codegym.product_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.product_manager.model.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {

    Iterable<Product> findByNameContaining(String name);

}
