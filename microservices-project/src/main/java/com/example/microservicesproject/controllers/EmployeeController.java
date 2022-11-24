package com.example.microservicesproject.controllers;

import com.example.microservicesproject.dto.EmployeeDTO;
import com.example.microservicesproject.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/")
public interface EmployeeController {
    @PostMapping("/department/{departmentId}/employees")
    ResponseEntity<ApiResponse> createEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable Integer departmentId);
    @PutMapping("/employees/{employeeId}")
    ResponseEntity<ApiResponse> updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable Integer employeeId);
    @GetMapping("/employees/{employeeId}")
    ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Integer employeeId);
    @GetMapping("/employees")
    ResponseEntity<List<EmployeeDTO>> getAllEmployees();
    @DeleteMapping("/employees/{employeeId}")
    ResponseEntity<ApiResponse> deleteEmployee(@PathVariable Integer employeeId);
}