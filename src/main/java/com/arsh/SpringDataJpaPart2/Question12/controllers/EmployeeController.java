package com.arsh.SpringDataJpaPart2.Question12.controllers;

import com.arsh.SpringDataJpaPart2.Question12.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService service;
    @GetMapping("/getEmployeeWitHighSalary")
    public List<String> getEmployee(){
        return service.getEmployeeWithHighSalary();
    }

    @PutMapping("/update-salary")
    public ResponseEntity<String> updateEmployeeSalary(@RequestParam Double salary) {
        if (salary == null) {
            return ResponseEntity.badRequest().body("Salary parameter is required.");
        }
        return service.updateSalary(salary);
    }

    @DeleteMapping("/delete-min-salary")
    public ResponseEntity<String> deleteEmployeesWithMinSalary() {
        return service.deleteEmployeesWithMinSalary();
    }

    @GetMapping("/lastname-singh")
    public ResponseEntity<?> getEmployeesWithLastNameSingh() {
        return service.getEmployeesWithLastNameSingh();
    }

    @DeleteMapping("delete-older-than/{age}")
    public ResponseEntity<String > deleteOlderThan(@PathVariable int age){
      return service.deleteEmployeeOlderThan(age);
    }
}
