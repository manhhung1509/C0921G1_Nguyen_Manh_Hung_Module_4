package com.example.demo.service.contract;

import com.example.demo.model.contract.ContractDetail;

public interface IContractDetailService {
    Iterable<ContractDetail> findAll();

    void save(ContractDetail contractDetail);
}
