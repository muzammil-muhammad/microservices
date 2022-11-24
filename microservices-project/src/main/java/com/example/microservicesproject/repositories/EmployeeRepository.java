package com.example.microservicesproject.repositories;

import com.example.microservicesproject.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
