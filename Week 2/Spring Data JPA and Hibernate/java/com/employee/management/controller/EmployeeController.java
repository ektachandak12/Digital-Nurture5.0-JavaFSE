package com.employee.management.controller;

import com.employee.management.entity.Employee;
import com.employee.management.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service){
        this.service = service;
    }

    // Create
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        return service.saveEmployee(employee);
    }

    // Read All
    @GetMapping
    public List<Employee> getEmployees(){
        return service.getAllEmployees();
    }

    // Read One
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return service.getEmployee(id);
    }

    // Update
    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee){
        return service.updateEmployee(employee);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id){
        service.deleteEmployee(id);
        return "Employee Deleted Successfully";
    }

}