package com.example.demo.dto;


import com.example.demo.model.contract.ContractDetail;
import com.example.demo.model.customer.Customer;
import com.example.demo.model.employee.Employee;
import com.example.demo.model.service.Services;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class ContractDto implements Validator {
    private  Integer id;
    @NotNull(message = "PLease input start date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private  Date contractStartDay;
    @NotNull(message = "PLease input end date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private  Date contractEndDay;
    @NotNull(message = "Contract deposit must not null.")
    @Min(value = 0,message = "Contract deposit must be big more than 0.")
    private Double contractDeposit;
    @NotNull(message = "Contract total not null.")
    @Min(value = 0,message = "Contract total must be big more than 0.")
    private Double contractTotal;

    private List<ContractDetail> contractDetails;

    private Services service;

    private Employee employee;

    private Customer customer;

    public ContractDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getContractStartDay() {
        return contractStartDay;
    }

    public void setContractStartDay(Date contractStartDay) {
        this.contractStartDay = contractStartDay;
    }

    public Date getContractEndDay() {
        return contractEndDay;
    }

    public void setContractEndDay(Date contractEndDay) {
        this.contractEndDay = contractEndDay;
    }

    public Double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(Double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public Double getContractTotal() {
        return contractTotal;
    }

    public void setContractTotal(Double contractTotal) {
        this.contractTotal = contractTotal;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public static Boolean checkDateContract(Date startDate, Date endDate) {
        boolean flag;
        if (startDate.compareTo(endDate) > 0) {
            flag = false;
        } else if (startDate.compareTo(endDate) < 0) {
            flag = true;
        } else {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;
        if (contractDto.contractStartDay != null && contractDto.contractEndDay != null) {
            if (!checkDateContract(contractDto.contractStartDay, contractDto.contractEndDay)) {
                errors.rejectValue("contractEndDay", "contractEndDay", "The end date must not be less than the start date");
            }
        }
    }
}