package com.example.demo.service.employee;

import com.example.demo.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable page);

    void save(Employee customer);

    Employee findEmployeeById(Integer id);

    void delete (Integer id);

    Page<Employee> searchEmployeeContaining(String name, String phone, String address, Pageable pageable);
}
