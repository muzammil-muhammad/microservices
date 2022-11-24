package com.example.microservicesproject.dto;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class DepartmentDTO {
    private Integer id;
    private String departmentName;
    private String departmentDescription;
    private Set<EmployeeDTO> employees = new HashSet<>();
}