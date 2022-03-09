package com.example.demo.controller;


import com.example.demo.model.contract.AttachService;
import com.example.demo.model.contract.Contract;
import com.example.demo.model.service.Services;
import com.example.demo.service.contract.IAttachServiceService;
import com.example.demo.service.contract.IContractService;
import com.example.demo.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/using-service")
public class CustomerUsingServiceController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private IServiceService serviceService;
    @Autowired
    private IAttachServiceService attachServiceService;

    @GetMapping(value = "/list")
    public ModelAndView goToCustomerUsing(@RequestParam Optional<String> id, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("customer_using_service/list");
        List<AttachService> attachServices = (List<AttachService>) attachServiceService.findAll();
        String idValue = "";
        if (id.isPresent()) {
            idValue = id.get();
        }
        Page<Contract> contracts = contractService.findAllCustomerId(idValue, pageable);
        modelAndView.addObject("attachServices", attachServices);
        modelAndView.addObject("contracts", contracts);
        return modelAndView;
    }

    @GetMapping(value = "/edit-contract/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        Optional<Contract> contract = contractService.findById(id);
        List<Services> services= (List<Services>) serviceService.findAll();
        ModelAndView modelAndView = new ModelAndView("/contract/edit");

        modelAndView.addObject("contract", contract.get());
        modelAndView.addObject("services", services);
        return modelAndView;

    }

    @PostMapping(value = "/edit-contract")
    public ModelAndView updateContract(@Validated @ModelAttribute Contract contract) {
        contractService.save(contract);
        ModelAndView modelAndView = new ModelAndView("contract/edit");
        modelAndView.addObject("contract", contract);
        modelAndView.addObject("mes", "contract update successfully");
        return modelAndView;


    }
}
