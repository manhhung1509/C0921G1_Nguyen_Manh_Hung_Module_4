package com.example.demo.service.contract.impl;

import com.example.demo.model.contract.Contract;
import com.example.demo.repository.contract.IContractRepository;
import com.example.demo.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class ContractService implements IContractService {

    @Autowired
    IContractRepository contractRepository;

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Iterable<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Optional<Contract> findById(Integer id) {
        return contractRepository.findById(id);
    }

    @Override
    public Page<Contract> findAllCustomerId(String id, Pageable page) {
        return contractRepository.findByCustomerCustomerId(id,page);
    }

//    public Double getTotalMoney(Contract c){
//
////        Date startDate = null;
//        try {
//            Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(c.getContractStartDay());
//            Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(c.getContractEndDay());
//            Double totalMoney = endDate.compareTo(startDate)*c.getService().getServiceCost();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        Double total = null;
//        return total;
//    }
}
