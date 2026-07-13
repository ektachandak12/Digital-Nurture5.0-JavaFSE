package com.employee.management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employees")

@NamedQueries({

        @NamedQuery(
                name = "Employee.findByEmployeeName",
                query = "SELECT e FROM Employee e WHERE e.name=:name"
        ),

        @NamedQuery(
                name = "Employee.findAllEmployees",
                query = "SELECT e FROM Employee e"
        )

})

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "department")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(unique=true)
    private String email;

    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;

}