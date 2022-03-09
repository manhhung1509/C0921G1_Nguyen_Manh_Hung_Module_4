package com.example.demo.service.contract.impl;

import com.example.demo.model.contract.ContractDetail;
import com.example.demo.repository.contract.IContractDetailRepository;
import com.example.demo.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class contractDetailService implements IContractDetailService {
    @Autowired
    IContractDetailRepository contractDetailRepository;
    @Override
    public Iterable<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }
}
