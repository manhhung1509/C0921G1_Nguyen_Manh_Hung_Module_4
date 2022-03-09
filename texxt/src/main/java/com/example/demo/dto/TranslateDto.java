package com.example.demo.dto;

import com.example.demo.model.Customer;
import com.example.demo.model.ServiceType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class TranslateDto implements Validator {

    private Integer id;

    @NotEmpty(message = "enter translate code")
    @Pattern(regexp = "^(MGD-)[0-9]{4}$", message = "translate code must be correct with format: MGD-XXXX")
    private String translateCode;

    @NotNull(message = "Please select customer")
    private Customer customer;

    @NotNull(message = "PLease input translate date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date translateDate;

    @NotNull(message = "Please select service type")
    private ServiceType serviceType;

    @NotEmpty(message = "enter unit")
    @Min(value = 500000,message = "area must be big more than 500000.")
    private String until;

    @NotNull(message = "enter area")
    @Min(value = 20,message = "area must be big more than 20.")
    private double area;

    private String flag;

    public TranslateDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTranslateCode() {
        return translateCode;
    }

    public void setTranslateCode(String translateCode) {
        this.translateCode = translateCode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getTranslateDate() {
        return translateDate;
    }

    public void setTranslateDate(Date translateDate) {
        this.translateDate = translateDate;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getUntil() {
        return until;
    }

    public void setUntil(String until) {
        this.until = until;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public static Boolean checkDateContract(Date translateDate) throws ParseException {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateString = df.format(date);
        final DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date dateNow = df1.parse(dateString);
       
        boolean flag;
        if (dateNow.compareTo(translateDate) > 0) {
            flag = false;
        } else if (dateNow.compareTo(translateDate) < 0) {
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
        TranslateDto translateDto = (TranslateDto) target;
        if (translateDto.translateDate != null) {
            try {
                if (!checkDateContract(translateDto.translateDate)) {
                    errors.rejectValue("translateDate", "translateDate", "The translate date must not be less than date now.");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}