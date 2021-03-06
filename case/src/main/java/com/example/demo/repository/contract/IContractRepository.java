package com.example.demo.repository.contract;

import com.example.demo.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends JpaRepository<Contract, Integer> {

    @Query(value = "select * from contract where  customer_id like %?1%",
            nativeQuery = true)
    Page<Contract> findByCustomerCustomerId(String id, Pageable pageable);
}
