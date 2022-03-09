package com.example.demo.controller;

import com.example.demo.dto.ContractDetailDto;
import com.example.demo.model.contract.AttachService;
import com.example.demo.model.contract.Contract;
import com.example.demo.model.contract.ContractDetail;
import com.example.demo.service.contract.IAttachServiceService;
import com.example.demo.service.contract.IContractDetailService;
import com.example.demo.service.contract.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/contract-details")
public class ContractDetailController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private IAttachServiceService attachServiceService;
    @Autowired
    private IContractDetailService contractDetailService;


    @ModelAttribute(value = "contracts")
    public Iterable<Contract> contracts() {
        return contractService.findAll();
    }

    @ModelAttribute(value = "attachServices")
    public Iterable<AttachService> attachServices() {
        return attachServiceService.findAll();
    }

    @GetMapping(value = {"/create-contract-detail"})
    public ModelAndView showCreateContractDetail(){
        ContractDetailDto contractDetailDto = new ContractDetailDto();
        ModelAndView modelAndView= new ModelAndView("contract/create-contract-detail");
        modelAndView.addObject("contractDetailDto", contractDetailDto);
        return  modelAndView;
    }

    @PostMapping(value = "/create-contract-detail")
    public ModelAndView saveContractDetail(@Validated @ModelAttribute ContractDetailDto contractDetailDto, BindingResult bindingResult){
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto,contractDetail);

        if (bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("/contract/create-contract-detail");
            modelAndView.addObject(bindingResult.getModel());
            return modelAndView;
        }else {
            contractDetailService.save(contractDetail);
            ModelAndView modelAndView = new ModelAndView("/contract/create-contract-detail");
            modelAndView.addObject("mes","new Contract detail created successfully");
            return modelAndView;
        }
    }
}
