package com.example.microservicesproject.services;

import com.example.microservicesproject.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    void createEmployee(EmployeeDTO employeeDTO, Integer departmentId);
    void updateEmployee(EmployeeDTO employeeDTO, Integer employeeId);
    EmployeeDTO getEmployeeById(Integer employeeId);
    List<EmployeeDTO> getAllEmployees();
    void deleteEmployee(Integer employeeId);
}