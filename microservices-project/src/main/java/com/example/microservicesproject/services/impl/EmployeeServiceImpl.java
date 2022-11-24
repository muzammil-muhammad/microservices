package com.example.microservicesproject.services.impl;

import com.example.microservicesproject.dto.EmployeeDTO;
import com.example.microservicesproject.exceptions.ResourceNotFoundException;
import com.example.microservicesproject.models.Department;
import com.example.microservicesproject.models.Employee;
import com.example.microservicesproject.repositories.DepartmentRepository;
import com.example.microservicesproject.repositories.EmployeeRepository;
import com.example.microservicesproject.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createEmployee(EmployeeDTO employeeDTO, Integer departmentId) {
        Employee employee = dtoToEmployee(employeeDTO);
        Department department = departmentRepository.findById(departmentId).orElseThrow(() ->
                new ResourceNotFoundException("Department", "Id", departmentId));
        employee.setDepartment(department);
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(EmployeeDTO employeeDTO, Integer employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "employee", employeeId));
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employeeRepository.save(employee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Integer employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "employee", employeeId));

        return employeeToDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(this::employeeToDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteEmployee(Integer employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "employee", employeeId));
        employeeRepository.delete(employee);
    }

    private Employee dtoToEmployee(EmployeeDTO employeeDTO) {
        return modelMapper.map(employeeDTO, Employee.class);
    }
    private EmployeeDTO employeeToDTO(Employee employee) {
        return modelMapper.map(employee, EmployeeDTO.class);
    }
}
