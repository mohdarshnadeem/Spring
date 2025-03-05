package com.arsh.RestfullWebServicesPart1.Question2345789.controllers;

import com.arsh.RestfullWebServicesPart1.Question2345789.Entity.Employee;
import com.arsh.RestfullWebServicesPart1.Question2345789.exception.EmployeeNotFoundException;
import com.arsh.RestfullWebServicesPart1.Question2345789.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeController {

    EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //fetchAll
    @GetMapping("/employees")
    public List<Employee> retrieveAllEmployees(){
        return employeeService.getAllEmployees();
    }
    //fetch by id
    @GetMapping("/employees/{id}")
    public Employee retrieveEmployeeById(@PathVariable int id){
        Employee employee= employeeService.getEmployeeById(id);
        if(employee == null){
            throw new EmployeeNotFoundException("User not found");
        }
        return employee;
    }
    // post an employee:
    //Client sends a POST request with user details.
    // API converts JSON into a User object and validates it.
    // User is saved in the main memory.
    //API returns a 201 Created response with a Location header pointing to the new user’s resource
    @PostMapping("/employees/create")
    public ResponseEntity<Employee> createEmployeeViaPost(@Valid @RequestBody Employee employee){
        Employee saved = employeeService.createEmployee(employee);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee){
        return employeeService.updateEmployee(id, updatedEmployee);
    }
}
