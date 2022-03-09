package com.example.demo.dto;

import com.example.demo.model.contract.Contract;
import com.example.demo.model.customer.CustomerType;
import com.example.demo.repository.customer.ICustomerRepository;
import com.example.demo.service.customer.ICustomerService;
import com.example.demo.service.customer.impl.CustomerService;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

import java.util.List;

public class CustomerDto {
    private Integer id;

    @NotEmpty(message = "enter customer code")
    @Pattern(regexp = "^(KH-)[0-9]{4}$", message = "Customer code must be correct with format: KH-XXXX")
    private String customerCode;

    private CustomerType customerType;

    @NotNull(message = "input must not null.")
    @NotBlank(message = "enter customer name")
    private String customerName;

    @NotBlank(message = "Please enter customer birth day.")
    @NotNull(message = "input must not null.")
    private String customerBirthDay;

    private String customerGender;

    @Pattern(regexp = "^\\d{9,12}$", message = "Enter number has 9 or 12 numbers.")
    private String customerIdCard;

    @NotNull(message = "input must not null.")
    @Pattern(regexp = "^(84+|0)(90|91)[0-9]{7}$", message = "phone number must matched with 090xxxxxxx or 091xxxxxxx or (84)+91xxxxxxx or (84)+90xxxxxxx")
    private String customerPhone;

    @NotBlank(message = "Please input email.")
    @Email(message = "Enter Incorrect format email")
//    @Pattern(regexp = "^[A-Za-z0-9._]+[@][A-Za-z0-9._]+[.][A-Za-z0-9._]+$")
    private String customerEmail;

    private String customerAddress;
    private List<Contract> contract;
    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public CustomerDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthDay() {
        return customerBirthDay;
    }

    public void setCustomerBirthDay(String customerBirthDay) {
        this.customerBirthDay = customerBirthDay;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public List<Contract> getContract() {
        return contract;
    }

    public void setContract(List<Contract> contract) {
        this.contract = contract;
    }


}