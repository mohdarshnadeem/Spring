package com.arsh.SpringDataJpaPart2.Question12.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employeeTable")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "empFirstName", nullable = false)
    private String firstName;

    @Column(name = "empLastName", nullable = false)
    private String lastName;

    @Column(name = "empSalary", nullable = false)
    private double salary;

    @Column(name = "empAge", nullable = false)
    private int age;

}
