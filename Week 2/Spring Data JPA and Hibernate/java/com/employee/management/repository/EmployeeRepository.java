package com.employee.management.repository;

import com.employee.management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    // Derived Queries

    Optional<Employee> findByEmail(String email);

    List<Employee> findByName(String name);

    List<Employee> findByDepartmentName(String name);

    List<Employee> findByDepartmentId(Long id);

    // JPQL Query

    @Query("SELECT e FROM Employee e WHERE e.email=?1")
    Employee getEmployeeByEmail(String email);

    @Query("SELECT e FROM Employee e WHERE e.name LIKE %?1%")
    List<Employee> searchEmployee(String keyword);

    // Named Query

    List<Employee> findByEmployeeName(String name);

}