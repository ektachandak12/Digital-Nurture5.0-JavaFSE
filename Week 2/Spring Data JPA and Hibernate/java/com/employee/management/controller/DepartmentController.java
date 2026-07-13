package com.employee.management.controller;

import com.employee.management.entity.Department;
import com.employee.management.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service){
        this.service = service;
    }

    // Create
    @PostMapping
    public Department addDepartment(@RequestBody Department department){
        return service.saveDepartment(department);
    }

    // Read All
    @GetMapping
    public List<Department> getDepartments(){
        return service.getAllDepartments();
    }

    // Read One
    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable Long id){
        return service.getDepartment(id);
    }

    // Update
    @PutMapping
    public Department updateDepartment(@RequestBody Department department){
        return service.updateDepartment(department);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable Long id){
        service.deleteDepartment(id);
        return "Department Deleted Successfully";
    }

}