package com.assignment.spring_boot.Question1and3.service;

import com.assignment.spring_boot.Question1and3.Entity.Employee;
import com.assignment.spring_boot.Question1and3.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> saveEmployees(List<Employee> employees){
        return employeeRepository.saveAll(employees);
    }
}
