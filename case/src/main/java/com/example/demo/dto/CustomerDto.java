package com.example.demo.dto;

import com.example.demo.model.customer.CustomerType;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CustomerDto {
    private Integer id;

    @NotBlank
    @Pattern(regexp ="^(KH-)[0-9]{4}$", message = "Customer code must be correct with format: KH-XXXX")
    private String customerCode;

    private CustomerType customerType;

    @NotNull(message = "input must not null.")
    @NotBlank
    private String customerName;

    @NotNull(message = "input must not null.")
    private String customerBirthDay;

    private String customerGender;

    @Pattern(regexp = "^\\d{9,10}$", message = "Enter incorrect format.")
    private String customerIdCard;

    @NotNull
    @Pattern(regexp = "^(84+|0)(90|91)[0-9]{7}$")
    private String customerPhone;

    @NotBlank(message = "Please input email.")
    @Email(message = "Enter Incorrect format.")
//    @Pattern(regexp = "^[A-Za-z0-9._]+[@][A-Za-z0-9._]+[.][A-Za-z0-9._]+$")
    private String customerEmail;

    private String customerAddress;


    public CustomerDto() {
    }

    public CustomerDto(String customerCode, CustomerType customerType, String customerName, String customerBirthDay,
                       String customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress) {
        this.customerCode = customerCode;
        this.customerType = customerType;
        this.customerName = customerName;
        this.customerBirthDay = customerBirthDay;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    public CustomerDto(Integer id, String customerCode, CustomerType customerType, String customerName, String customerBirthDay, String customerGender,
                       String customerIdCard, String customerPhone, String customerEmail, String customerAddress) {
        this.id = id;
        this.customerCode = customerCode;
        this.customerType = customerType;
        this.customerName = customerName;
        this.customerBirthDay = customerBirthDay;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
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

}