package com.assignment.spring_boot.Question1and3.controller;

import com.assignment.spring_boot.Question1and3.Entity.Employee;
import com.assignment.spring_boot.Question1and3.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/save_employees")
    public List<Employee> saveEmployees(@RequestBody List<Employee> employees){
        return employeeService.saveEmployees(employees);
    }
}
