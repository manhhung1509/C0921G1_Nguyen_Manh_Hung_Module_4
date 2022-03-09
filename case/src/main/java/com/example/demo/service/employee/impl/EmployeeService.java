package com.example.demo.service.employee.impl;

import com.example.demo.model.employee.Employee;
import com.example.demo.repository.employee.IEmployeeRepository;
import com.example.demo.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepository employeeRepository;


    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Page<Employee> findAll(Pageable page) {
        return employeeRepository.findAll(page);
    }

    @Override
    public void save(Employee employee) {
        employee.setFlag("1");
        employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public void delete(Employee employee) {
        employee.setFlag("0");
        employeeRepository.save(employee);
    }

    @Override
    public Page<Employee> searchEmployeeContaining(String name, String phone, String address, Pageable pageable) {
        return employeeRepository.searchEmployee(name, phone, address, pageable);
    }
}
