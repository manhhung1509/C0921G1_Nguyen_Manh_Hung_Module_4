package com.example.demo.service.employee;

import com.example.demo.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Iterable<Employee> findAll();

    Page<Employee> findAll(Pageable page);

    void save(Employee customer);

    Employee findEmployeeById(Integer id);

    void delete (Employee employee);

    Page<Employee> searchEmployeeContaining(String name, String phone, String address, Pageable pageable);
}
