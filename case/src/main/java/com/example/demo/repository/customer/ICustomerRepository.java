package com.example.demo.repository.customer;

import com.example.demo.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

    Customer findCustomerById(Integer id);

    @Query(value = "select * from customer where  customer_name like %?1% and customer_email like %?2% and customer_address like %?3% ",
            nativeQuery = true)
    Page<Customer> searchCustomer(String name, String email, String address, Pageable pageable);
}
