package com.example.microservicesproject.services.impl;

import com.example.microservicesproject.dto.DepartmentDTO;
import com.example.microservicesproject.exceptions.ResourceNotFoundException;
import com.example.microservicesproject.models.Department;
import com.example.microservicesproject.repositories.DepartmentRepository;
import com.example.microservicesproject.services.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public void createDepartment(DepartmentDTO departmentDTO) {
        departmentRepository.save(dtoToDepartment(departmentDTO));
    }

    @Override
    public void updateDepartment(DepartmentDTO departmentDTO, Integer departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() ->
                new ResourceNotFoundException("Department", "Id", departmentId));
        department.setDepartmentName(departmentDTO.getDepartmentName());
        departmentRepository.save(department);
    }

    @Override
    public DepartmentDTO getDepartmentById(Integer departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() ->
                new ResourceNotFoundException("Department", "Id", departmentId));
        return departmentToDTO(department);
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map(this::departmentToDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteDepartment(Integer departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() ->
                new ResourceNotFoundException("Department", "Id", departmentId));
        departmentRepository.delete(department);
    }

    private Department dtoToDepartment(DepartmentDTO departmentDTO) {
        return modelMapper.map(departmentDTO, Department.class);
    }

    private DepartmentDTO departmentToDTO(Department department) {
        return modelMapper.map(department, DepartmentDTO.class);
    }
}