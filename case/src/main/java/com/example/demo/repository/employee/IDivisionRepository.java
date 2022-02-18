package com.example.demo.repository.employee;

import com.example.demo.model.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface IDivisionRepository extends JpaRepository<Division, Integer> {
}
