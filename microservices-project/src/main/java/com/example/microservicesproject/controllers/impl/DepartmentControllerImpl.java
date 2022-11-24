package com.example.microservicesproject.controllers.impl;

import com.example.microservicesproject.controllers.DepartmentController;
import com.example.microservicesproject.dto.DepartmentDTO;
import com.example.microservicesproject.responses.ApiResponse;
import com.example.microservicesproject.services.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class DepartmentControllerImpl implements DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentControllerImpl(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public ResponseEntity<ApiResponse> createDepartment(DepartmentDTO departmentDTO) {
        departmentService.createDepartment(departmentDTO);
        return new ResponseEntity<>(new ApiResponse(
                "Department added successfully",
                true,
                new Date()
        ), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ApiResponse> updateDepartment(DepartmentDTO departmentDTO, Integer departmentId) {
        departmentService.updateDepartment(departmentDTO, departmentId);
        return new ResponseEntity<>(new ApiResponse(
                "Department updated successfully",
                true,
                new Date()
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DepartmentDTO> getDepartmentById(Integer departmentId) {
        return new ResponseEntity<>(departmentService.getDepartmentById(departmentId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<DepartmentDTO>> getAllDepartment() {
        return new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse> deleteDepartment(Integer departmentId) {
        departmentService.deleteDepartment(departmentId);
        return new ResponseEntity<>(new ApiResponse(
                "Department deleted successfully",
                true,
                new Date()
        ), HttpStatus.OK);
    }
}
