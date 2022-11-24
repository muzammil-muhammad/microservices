package com.example.microservicesproject.repositories;

import com.example.microservicesproject.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
