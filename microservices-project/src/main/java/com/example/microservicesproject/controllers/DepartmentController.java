package com.example.microservicesproject.controllers;

import com.example.microservicesproject.dto.DepartmentDTO;
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
public interface DepartmentController {
    @PostMapping("/departments")
    ResponseEntity<ApiResponse> createDepartment(@RequestBody DepartmentDTO departmentDTO);
    @PutMapping("/departments/{departmentId}")
    ResponseEntity<ApiResponse> updateDepartment(@RequestBody DepartmentDTO departmentDTO, @PathVariable Integer departmentId);
    @GetMapping("/departments/{departmentId}")
    ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Integer departmentId);
    @GetMapping("/departments")
    ResponseEntity<List<DepartmentDTO>> getAllDepartment();
    @DeleteMapping("/departments/{departmentId}")
    ResponseEntity<ApiResponse> deleteDepartment(@PathVariable Integer departmentId);
}