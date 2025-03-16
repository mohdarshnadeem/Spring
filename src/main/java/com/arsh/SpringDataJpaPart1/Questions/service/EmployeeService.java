package com.arsh.SpringDataJpaPart1.Questions.service;

import com.arsh.SpringDataJpaPart1.Questions.Entities.Employee;
import com.arsh.SpringDataJpaPart1.Questions.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;
    public ResponseEntity<Employee> createEmployee(Employee employee) {
        return new ResponseEntity<Employee>(repository.save(employee), HttpStatus.CREATED);
    }

    public ResponseEntity<Employee> updateEmployee(Employee employee, Integer id) {

        Optional<Employee> oldEmployee = repository.findById(id);
        if(oldEmployee.isEmpty()){
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        oldEmployee.ifPresent(emp->{
            emp.setName(employee.getName() != null && !employee.getName().isEmpty() ? employee.getName() : emp.getName());
            emp.setAge(employee.getAge() != null ? employee.getAge() : emp.getAge());
            repository.save(emp);
        });
        return new ResponseEntity<>(oldEmployee.get(),HttpStatus.OK);

    }

    public ResponseEntity<String> deleteEmployee(Integer id) {

         if(repository.existsById(id)){
             repository.deleteById(id);
             return new ResponseEntity<>("Employee with id: "+id+" deleted successfully", HttpStatus.OK);
         }
         return new ResponseEntity<>("No employee found with this id",HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<List<Employee>> getEmployees() {
        return new ResponseEntity<>(repository.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<Long> getCount() {
        return new ResponseEntity<>(repository.count(),HttpStatus.OK);
    }


    public ResponseEntity<List<Employee>> getEmployeesPagingAndSorting(int page, int size, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase("asc")
                ? Sort.by("age").ascending()
                : Sort.by("age").descending();

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Employee> employeePage = repository.findAll(pageable);

        return new ResponseEntity<>(employeePage.getContent(), HttpStatus.OK);
    }

    public List<Employee> findByName(String name) {
        return repository.findByName(name);
    }

    public List<Employee> findByNameStartingWithA(String var) {
        return repository.findByNameStartingWith(var);
    }

    public List<Employee> ageBetween(int a, int b) {
        return repository.findByAgeBetween(a,b);
    }
}
