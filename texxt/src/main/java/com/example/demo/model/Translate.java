package com.example.demo.model;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Translate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String translateCode;
    @ManyToOne()
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    private Date translateDate;
    @ManyToOne()
    @JoinColumn(name = "serviceType_id", referencedColumnName = "id")
    private ServiceType serviceType;
    private String until;
    private Double area;
    private String flag;

    public Translate() {
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
}
