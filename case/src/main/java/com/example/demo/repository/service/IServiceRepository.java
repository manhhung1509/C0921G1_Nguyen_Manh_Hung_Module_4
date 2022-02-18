package com.example.demo.repository.service;

import com.example.demo.model.service.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceRepository extends JpaRepository<Services, Integer> {
}
