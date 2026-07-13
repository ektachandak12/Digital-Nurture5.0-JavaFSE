package com.employee.management.service;

import com.employee.management.entity.Department;
import com.employee.management.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository){
        this.repository = repository;
    }

    public Department saveDepartment(Department department){
        return repository.save(department);
    }

    public List<Department> getAllDepartments(){
        return repository.findAll();
    }

    public Department getDepartment(Long id){
        return repository.findById(id).orElse(null);
    }

    public Department updateDepartment(Department department){
        return repository.save(department);
    }

    public void deleteDepartment(Long id){
        repository.deleteById(id);
    }

}