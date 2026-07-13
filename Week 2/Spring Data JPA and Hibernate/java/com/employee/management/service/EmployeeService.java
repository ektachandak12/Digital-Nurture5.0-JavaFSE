package com.employee.management.service;

import com.employee.management.entity.Employee;
import com.employee.management.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    // Create
    public Employee saveEmployee(Employee employee){
        return repository.save(employee);
    }

    // Read All
    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }

    // Read One
    public Employee getEmployee(Long id){
        return repository.findById(id).orElse(null);
    }

    // Update
    public Employee updateEmployee(Employee employee){
        return repository.save(employee);
    }

    // Delete
    public void deleteEmployee(Long id){
        repository.deleteById(id);
    }

}