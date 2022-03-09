package com.example.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EmailDto {
    @NotNull(message = "Contract start date must not null.")
    @NotBlank(message = "Contract start date must not blank.")
    private  String to;
    @NotNull(message = "Contract end date must not null")
    @NotBlank(message = "Please enter contract end date.")
    private  String subject;

    public EmailDto() {
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
