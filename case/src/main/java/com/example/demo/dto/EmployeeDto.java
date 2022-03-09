package com.example.demo.dto;

import com.example.demo.model.employee.Division;
import com.example.demo.model.employee.EducationDegree;
import com.example.demo.model.employee.Position;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class EmployeeDto implements Validator {
    private  Integer id;
    @NotNull(message = "input must not null.")
    @NotBlank(message = "enter employee name.")
    private  String employeeName;
    @NotNull(message = "PLease input birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date employeeBirthday;
    @NotEmpty(message = "input must not empty.")
    @Min(value = 0,message = "Id card must be big more than 0.")
    @Pattern(regexp = "^\\d{12}|\\d{9}$", message = "Invalid id card format")
    private String employeeIdCard;
    @NotNull(message = "enter salary")
    private Double employeeSalary;
    @NotNull(message = "not null")
    @NotEmpty(message = "not empty")
    @Pattern(regexp = "^[0-9]{10}", message = "")
    private  String employeePhone;
    @NotEmpty
    @Email(message = "Invalid email format")
    private  String employeeEmail;
    @NotNull
    private String employeeAddress;
    @NotNull(message = "Please select division")
    private Division division;
    private Position position;
    private EducationDegree educationDegree;
    private String flag;
    private String userName;
    private String passWord;

    public EmployeeDto() {
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(Date employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public static boolean checkDate(Date employeeBirthday) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(employeeBirthday);
        LocalDate date = LocalDate.of(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH) + 1,
                cal.get(Calendar.DAY_OF_MONTH));
        boolean flag = false;
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(date, currentDate).getYears();
        if (age < 100 && age >= 18) {
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
        EmployeeDto employeeDto = (EmployeeDto) target;
        if (employeeDto.employeeBirthday != null){
            if (!checkDate(employeeDto.employeeBirthday)) {
                errors.rejectValue("employeeBirthday", "birthDay", "Employee is under 18 years old");
            }
        }
    }
}
