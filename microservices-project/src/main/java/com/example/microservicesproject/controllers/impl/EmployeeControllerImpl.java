package com.example.microservicesproject.controllers.impl;

import com.example.microservicesproject.controllers.EmployeeController;
import com.example.microservicesproject.dto.EmployeeDTO;
import com.example.microservicesproject.responses.ApiResponse;
import com.example.microservicesproject.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class EmployeeControllerImpl implements EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeControllerImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public ResponseEntity<ApiResponse> createEmployee(EmployeeDTO employeeDTO, Integer departmentId) {
        employeeService.createEmployee(employeeDTO, departmentId);
        return new ResponseEntity<>(new ApiResponse(
                "Employee Added successfully",
                true,
                new Date()
        ), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ApiResponse> updateEmployee(EmployeeDTO employeeDTO, Integer employeeId) {
        employeeService.updateEmployee(employeeDTO, employeeId);

        return new ResponseEntity<>(new ApiResponse(
                "Employee updated successfully",
                true,
                new Date()
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EmployeeDTO> getEmployeeById(Integer employeeId) {
        return new ResponseEntity<>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse> deleteEmployee(Integer employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(new ApiResponse(
                "Employee Deleted Successfully",
                true,
                new Date()
        ), HttpStatus.OK);
    }
}
