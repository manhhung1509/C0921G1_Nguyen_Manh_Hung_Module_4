package com.example.demo.model.contract;


import com.example.demo.model.customer.Customer;
import com.example.demo.model.employee.Employee;
import com.example.demo.model.service.Services;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date contractStartDay;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private  Date contractEndDay;
    private double contractDeposit;
    private double contractTotal;
    @OneToMany(targetEntity = ContractDetail.class)
    private List<ContractDetail> contractDetails;

    @ManyToOne()
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    private Services service;

    @ManyToOne()
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne()
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    public Contract() {
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

    public double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public double getContractTotal() {
        return contractTotal;
    }

    public void setContractTotal(double contractTotal) {
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
}