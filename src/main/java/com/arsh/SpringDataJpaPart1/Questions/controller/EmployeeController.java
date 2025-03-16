package com.arsh.SpringDataJpaPart1.Questions.controller;

import com.arsh.SpringDataJpaPart1.Questions.Entities.Employee;
import com.arsh.SpringDataJpaPart1.Questions.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService service;
//    answer3
    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        return service.createEmployee(employee);
    }

//  answer4
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable Integer id){
        return service.updateEmployee(employee, id);
    }

    //  answer5
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String > deleteEmployee(@PathVariable Integer id){
        return service.deleteEmployee(id);
    }

    //  answer6
    @GetMapping("/get")
    public ResponseEntity<List<Employee>> getEmployees(){
        return service.getEmployees();
    }

    //  answer7
    @GetMapping("/count")
    public ResponseEntity<Long> getEmployeeCount(){
        return service.getCount();
    }

    //  answer8
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getEmployeesPagingAndSorting(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size,
            @RequestParam(defaultValue = "asc") String sort
    ){
        return service.getEmployeesPagingAndSorting(page, size, sort);
    }

    //  answer9
    @GetMapping("/findByName/{name}")
    public List<Employee> findByName(@PathVariable String name){
        return service.findByName(name);
    }

    //  answer10
    @GetMapping("/startingWithA/{var}")
    public List<Employee> statingWithA(@PathVariable String var){
        return service.findByNameStartingWithA(var);
    }

    //  answer11
    @GetMapping("/ageBetween/{a}/{b}")
    public List<Employee> ageBetween(@PathVariable int a,@PathVariable int b){
        return service.ageBetween(a,b);
    }

}

