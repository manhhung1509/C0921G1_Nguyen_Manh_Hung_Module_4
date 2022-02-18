package com.example.demo.repository.employee;

import com.example.demo.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findEmployeeById(Integer id);

    @Query(value = "select * from employee where  employee_name like %?1% and employee_phone like %?2% and employee_address like %?3% ",
            nativeQuery = true)
    Page<Employee> searchEmployee(String name, String phone, String address, Pageable pageable);
}
