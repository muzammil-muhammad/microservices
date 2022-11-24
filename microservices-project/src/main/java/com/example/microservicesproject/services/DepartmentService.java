package com.example.microservicesproject.services;

import com.example.microservicesproject.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {
    void createDepartment(DepartmentDTO departmentDTO);
    void updateDepartment(DepartmentDTO departmentDTO, Integer departmentId);
    DepartmentDTO getDepartmentById(Integer departmentId);
    List<DepartmentDTO> getAllDepartments();
    void deleteDepartment(Integer departmentId);
}
