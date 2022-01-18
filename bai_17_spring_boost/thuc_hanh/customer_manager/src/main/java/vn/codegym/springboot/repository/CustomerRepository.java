package vn.codegym.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.springboot.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
