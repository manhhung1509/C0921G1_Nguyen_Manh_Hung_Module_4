package com.example.demo.repository;

import com.example.demo.model.Customer;
import com.example.demo.model.Translate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
}
