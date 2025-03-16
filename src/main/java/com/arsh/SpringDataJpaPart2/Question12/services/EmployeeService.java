package com.arsh.SpringDataJpaPart2.Question12.services;

import com.arsh.SpringDataJpaPart2.Question12.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository repository;

    public List<String> getEmployeeWithHighSalary() {
        List<Object[]> result = repository.findEmployeesWithSalaryGreaterThanAverage();
        List<String> employees = new ArrayList<>();
        for (Object[] obj : result) {
            employees.add(obj[0] + " " + obj[1]);
        }
        return employees;
    }

    @Transactional
    public ResponseEntity<String> updateSalary(double newSalary) {
        int updatedRows = repository.updateSalaryForEmployeesBelowAverage(newSalary);

        if (updatedRows > 0) {
            return ResponseEntity.ok(updatedRows + " employees' salaries updated successfully.");
        } else {
            return ResponseEntity.ok("No employees had salaries below average.");
        }
    }

    public ResponseEntity<String> deleteEmployeesWithMinSalary() {
        Double minSalary = repository.findMinSalary();

        if (minSalary == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No employees found to delete.");
        }

        repository.deleteEmployeesWithMinSalary(minSalary);
        return ResponseEntity.ok("Deleted all employees with minimum salary: " + minSalary);
    }

    public ResponseEntity<?> getEmployeesWithLastNameSingh() {
        List<Object[]> results = repository.findEmployeesWithLastNameSingh();

        if (results.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No employees found with last name ending in 'Singh'.");
        }

        List<Map<String, Object>> employees = new ArrayList<>();
        for (Object[] row : results) {
            Map<String, Object> employee = new HashMap<>();
            employee.put("id", row[0]);
            employee.put("firstName", row[1]);
            employee.put("age", row[2]);
            employees.add(employee);
        }
        return ResponseEntity.ok(employees);
    }

    public ResponseEntity<String> deleteEmployeeOlderThan(int age){
        int deleteCount = repository.deleteEmployeeOlderThan(age);

        if(deleteCount == 0){
            return new ResponseEntity<>("no employee greater than "+age,HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(deleteCount+ " employees deleted successfully", HttpStatus.OK);
    }
}
