package com.employee.management.repository;

import com.employee.management.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

    Optional<Department> findByName(String name);

    @Query("SELECT d FROM Department d WHERE d.name=?1")
    Department getDepartmentByName(String name);

}