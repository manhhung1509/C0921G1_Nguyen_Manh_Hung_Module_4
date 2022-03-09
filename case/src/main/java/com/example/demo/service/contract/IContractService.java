package com.example.demo.service.contract;

import com.example.demo.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IContractService {
    void save(Contract contract);

    Page<Contract> findAll(Pageable pageable);

    Iterable<Contract> findAll();

    Optional<Contract> findById(Integer id);

    Page<Contract> findAllCustomerId(String id, Pageable page);
}
